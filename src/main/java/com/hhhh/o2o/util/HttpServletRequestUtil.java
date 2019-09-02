package com.hhhh.o2o.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public class HttpServletRequestUtil {

    public static int getInt(HttpServletRequest request, String key) {
        try {
            Integer reInt = Integer.decode(request.getParameter(key));
            if (reInt == null) {
                MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
                return Integer.decode(mRequest.getParameter(key));
            }
            return reInt;
        } catch (Exception e) {
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request, String key) {
        try {
            Long reLong = Long.valueOf(request.getParameter(key));
            if (reLong == null) {
                MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
                return Long.valueOf(mRequest.getParameter(key));
            }
            return reLong;
        } catch (Exception e) {
            return -1;
        }
    }

    public static double getDouble(HttpServletRequest request, String key) {

        try {
            Double reDouble = Double.valueOf(request.getParameter(key));
            if (reDouble == null) {
                MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
                return Double.valueOf(mRequest.getParameter(key));
            }
            return reDouble;
        } catch (Exception e) {
            return -1d;
        }
    }

    public static boolean getBoolean(HttpServletRequest request, String key) {

        try {
            Boolean reBoolean = Boolean.valueOf(request.getParameter(key));
            if (reBoolean == null) {
                MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
                return Boolean.valueOf(mRequest.getParameter(key));
            }
            return reBoolean;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static String getString(HttpServletRequest request, String key) {
        try {
            String reString = request.getParameter(key);
            if (reString == null) {
                MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
                String result = mRequest.getParameter(key);
                if (result != null) {
                    result = result.trim();
                }
                if ("".equals(result)) {
                    result = null;
                }
                return result;
            }
            return reString;
        } catch (Exception e) {
            return null;
        }
    }
}
