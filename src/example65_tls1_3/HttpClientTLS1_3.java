package example65_tls1_3;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.time.Duration;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpClientTLS1_3 {

	protected static String taxJsonUrl = "";
	protected static String taxSubscriptionUrl = "";

	public static void main(String[] args) {

		try {
			String json = task1();
			String[] jsonary = json.split("TCPASS");
			if (jsonary != null && jsonary.length > 0) {
				for (int i = 0; i < jsonary.length; i++) {
					task2(json);
				}
			}
		} catch (IOException | InterruptedException e) {
			System.out.println(e.toString());
		}

	}

	public static String task1() throws IOException, InterruptedException {

		HttpClient httpClient = null;
		try {
			httpClient = HttpClient.newBuilder().sslContext(createIgnoreVerifySSL()).version(HttpClient.Version.HTTP_2)
					.connectTimeout(Duration.ofSeconds(10)).build();
		} catch (KeyManagementException | NoSuchAlgorithmException e) {
			System.out.println(e.toString());
		}

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(taxJsonUrl)).setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.83 Safari/537.36")
				.GET().build();

		// 同步呼叫
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		// print response headers
		// HttpHeaders headers = response.headers();
		// headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

		// print status code
		// System.out.println(response.statusCode());

		// print response body
		// System.out.println(response.body());
		return response.body();

	}

	public static void task2(String json) throws IOException, InterruptedException {

		System.out.println("json:" + json);

		HttpClient httpClient = null;
		try {
			httpClient = HttpClient.newBuilder().sslContext(createIgnoreVerifySSL()).version(HttpClient.Version.HTTP_2)
					.connectTimeout(Duration.ofSeconds(10)).build();
		} catch (KeyManagementException | NoSuchAlgorithmException e) {
			System.out.println(e.toString());
		}

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(taxSubscriptionUrl)).setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.83 Safari/537.36") // header
				.header("Content-Type", "application/json;charset=UTF-8")
				.POST(HttpRequest.BodyPublishers.ofString(json)).build();

		// 同步呼叫
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		// print response headers
		HttpHeaders headers = response.headers();
		headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

		// print status code
		System.out.println(response.statusCode());

		// print response body
		System.out.println(response.body());

	}

	public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sc = SSLContext.getInstance("SSLv3");

		// 實現一個X509TrustManager接口，用於繞過驗證，不用修改裡面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};

		sc.init(null, new TrustManager[] { trustManager }, null);
		return sc;
	}

}