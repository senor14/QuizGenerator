package poly.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import poly.service.IKakaoService;

@Service("KakaoService")
public class KakaoService implements IKakaoService{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	 public String getAccessToken (String authorize_code) {
         String access_Token = "";
         String refresh_Token = "";
         String reqURL = "https://kauth.kakao.com/oauth/token";

         try {
             URL url = new URL(reqURL);

             HttpURLConnection conn = (HttpURLConnection) url.openConnection();

             //    POST 요청을 위해 기본값이 false인 setDoOutput을 true로

             conn.setRequestMethod("POST");
             conn.setDoOutput(true);

             //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
             StringBuilder sb = new StringBuilder();
             sb.append("grant_type=authorization_code");
             sb.append("&client_id=fb949699752a4185310c104921155f37");  //본인이 발급받은 key
             sb.append("&redirect_uri=http://localhost:9999/main/mainPage.do");     // 본인이 설정해 놓은 경로
             sb.append("&code=" + authorize_code);
             bw.write(sb.toString());
             bw.flush();

             //    결과 코드가 200이라면 성공
             int responseCode = conn.getResponseCode();
             log.info("responseCode : " + responseCode);

             //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
             BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
             String line = "";
             String result = "";

             while ((line = br.readLine()) != null) {
                 result += line;
             }
             log.info("response body : " + result);

             //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
             JsonParser parser = new JsonParser();
             JsonElement element = parser.parse(result);

             access_Token = element.getAsJsonObject().get("access_token").getAsString();
             refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

             log.info("access_token : " + access_Token);
             log.info("refresh_token : " + refresh_Token);

             br.close();
             bw.close();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }

         return access_Token;
     }

	@Override
	public HashMap<String, Object> getUserInfo(String access_Token) {
        //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> userInfo = new HashMap<>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            log.info("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            log.info("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String profile_image = properties.getAsJsonObject().get("profile_image").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();

            userInfo.put("nickname", nickname);
            userInfo.put("email", email);
            userInfo.put("profile_image", profile_image);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userInfo;
	}
	
	/*
	 * @Override public JsonNode getAccessToken (String authorize_code) { final
	 * String RequestUrl = "https://kauth.kakao.com/oauth/token";
	 * 
	 * final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
	 * 
	 * postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
	 * 
	 * postParams.add(new BasicNameValuePair("client_id",
	 * "fb949699752a4185310c104921155f37"));
	 * 
	 * postParams.add(new BasicNameValuePair("redirect_uri",
	 * "http://localhost:8080/kakaoLogin.do"));
	 * 
	 * postParams.add(new BasicNameValuePair("code", authorize_code));
	 * 
	 * final HttpClient client = HttpClientBuilder.create().build();
	 * 
	 * final HttpPost post = new HttpPost(RequestUrl);
	 * 
	 * JsonNode returnNode = null;
	 * 
	 * try {
	 * 
	 * post.setEntity(new UrlEncodedFormEntity(postParams));
	 * 
	 * final HttpResponse response = client.execute(post);
	 * 
	 * ObjectMapper mapper = new ObjectMapper();
	 * 
	 * returnNode = mapper.readTree(response.getEntity().getContent());
	 * 
	 * } catch (UnsupportedEncodingException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } catch (ClientProtocolException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } catch (IOException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } finally {
	 * 
	 * }
	 * 
	 * return returnNode;
	 * 
	 * }
	 */
}
