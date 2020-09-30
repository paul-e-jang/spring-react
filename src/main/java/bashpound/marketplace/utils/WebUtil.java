package bashpound.marketplace.utils;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	    private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
	    private static final String X_REQUESTED_WITH = "X-Requested-With";

	    private static final String CONTENT_TYPE = "Content-type";
	    private static final String CONTENT_TYPE_JSON = "application/json";

	    public static boolean isAjax(HttpServletRequest request) {
	        return CONTENT_TYPE_JSON.equals(request.getHeader(CONTENT_TYPE));
	    }

	    public static boolean isContentTypeJson(HttpServletRequest request) {
	        return request.getHeader(CONTENT_TYPE).contains(CONTENT_TYPE_JSON);
	    }
}
