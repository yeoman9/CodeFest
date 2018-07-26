package com;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUploadController {

	private static final String TARGET_URL = "https://vision.googleapis.com/v1/images:annotate?";
	private static final String API_KEY = "key=YOUR_API_KEY";

	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public String uploadFile( @RequestParam(value = "uploadfile")MultipartFile file )
			throws IOException {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "D:\\Images";
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getName());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("You successfully uploaded file=" + file.getName());

				URL serverUrl;
				try {
					serverUrl = new URL(TARGET_URL + API_KEY);
					URLConnection urlConnection = serverUrl.openConnection();
					HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;

					httpConnection.setRequestMethod("POST");
					httpConnection.setRequestProperty("Content-Type", "application/json");

					httpConnection.setDoOutput(true);
					BufferedWriter httpRequestBodyWriter = new BufferedWriter(
							new OutputStreamWriter(httpConnection.getOutputStream()));
					httpRequestBodyWriter.write("{\"requests\":  [{ \"features\":  [ {\"type\": \"LABEL_DETECTION\""
							+ "}], \"image\": {\"source\": { \"gcsImageUri\":"
							+ " \"gs://vision-sample-images/4_Kittens.jpg\"}}}]}");
					httpRequestBodyWriter.close();

					String response = httpConnection.getResponseMessage();

					System.out.println(response);

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return "visionData";
			} catch (Exception e) {
				return "ErrorHandling";
			}
		} else {
			return "ErrorHandling";
		}
	}
}