package dicdic.utils.rest;

import java.util.Map;

/**
 * Created by 1001073 on 15. 4. 6..
 */
public interface CustomRestTemplate {
    public String sendGet(String url);
    public <T> T sendGet(String url, Class<T> responseClass);
    public <T> T sendGet(String url, Map<String, String> getParamMap, Class<T> responseClass);
    public <T> T sendPost(String url, Object paramBodyObj);
    public <T> T sendPost(String url, String paramBodyStr);
    public <T> T sendPost(String url, Map<String, Object> paramBodyMap);
}
