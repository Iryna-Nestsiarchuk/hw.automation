package regression.api;

import com.jayway.jsonpath.JsonPath;
import core.configuration.Configuration;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class VKTest {
    private String accessToken = Configuration.getVKAccessToken();
    private HttpClient client = HttpClientBuilder.create().build();
    private String wallOwner = Configuration.getVKWallOwner();

    @Test
    public void VKTest() throws URISyntaxException, IOException {
        URIBuilder createPostBuilder = createBuilder("post").setParameter("owner_id", wallOwner)
                .setParameter("message", "❤");
        String postId = getPostId(createPostBuilder);
        Assert.assertTrue(postId.matches("\\d+"));

        URIBuilder getPostByIdBuilder = createBuilder("getById")
                .setParameter("posts", String.format("%s_%s", wallOwner, postId));
        String postText = getText(getPostByIdBuilder);
        Assert.assertEquals("❤", postText);

        URIBuilder editPostBuilder = createBuilder("edit")
                .setParameter("message", "editedText")
                .setParameter("owner_id", wallOwner)
                .setParameter("post_id", postId);
        getResponse(editPostBuilder);
        URIBuilder getEditedPostByIdBuilder = createBuilder("getById")
                .setParameter("posts", String.format("%s_%s", wallOwner, postId));
        String postEditedText = getText(getEditedPostByIdBuilder);
        Assert.assertEquals("editedText", postEditedText);

        URIBuilder deletePostBuilder = createBuilder("delete")
                .setParameter("owner_id", wallOwner)
                .setParameter("post_id", postId);
        String deletePostResponse = getResponse(deletePostBuilder);
        Assert.assertTrue(deletePostResponse.contains("1"));
    }

    public URIBuilder createBuilder(String action) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(String.format("https://api.vk.com/method/wall.%s?", action));
        return builder.setParameter("access_token", accessToken).setParameter("v", "5.103");
    }

    public String getResponse(URIBuilder builder) throws URISyntaxException, IOException {
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        return EntityUtils.toString(response.getEntity());
    }

    public String getText(URIBuilder builder) throws IOException, URISyntaxException {
        String jsonString = getResponse(builder);
        String text = JsonPath.read(jsonString, "$.response[0].text");
        return text;
    }

    public String getPostId(URIBuilder builder) throws IOException, URISyntaxException {
        String jsonString = getResponse(builder);
        Integer postId = JsonPath.read(jsonString, "$.response.post_id");
        return String.valueOf(postId);
    }
}
