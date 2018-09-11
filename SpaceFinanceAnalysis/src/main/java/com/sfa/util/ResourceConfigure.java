package com.sfa.util;

/**
 * @author alixy
 */

public interface ResourceConfigure {

    /**
     * 服务器IP地址
     */
    String SERVER_HOST = "http://127.0.0.1:8080";
    //    String SERVER_HOST = "http://192.168.18.91:8080";
//    String SERVER_HOST = "http://yanfa.tenio.net:2018";
// String SERVER_HOST = "http://106.2.4.91:8077";
//    String SERVER_HOST = "http://106.2.4.91:9999";
    /**
     * 前端服务器地址
     */
//    String CLIENT_HOST = "http://127.0.0.1:8888";
    String CLIENT_HOST = "http://192.168.18.91:8080";
//    String CLIENT_HOST = "http://106.2.4.91:8077";
//    String CLIENT_HOST = "http://106.2.4.91:9999";
    /**
     * 文件夹根路径
     */
//    String ROOTPATH = "C:/Users/Administrator/Desktop/ProfitMeasurement";
//    String ROOTPATH = "D:/Workspaces/Test";
    String ROOTPATH = "D:/ProfitMeasurement";
    /**
     * 产品去化模型Excel模板路径
     */
    String FILE_PRODUCT_REMOVAL_TEMPLATE = ROOTPATH + "/file/productRemoval/template/product-template.xlsx";

    /**
     * 产品去化模型Excel上传与下载的文件路径
     */
    String FILE_PRODUCT_REMOVAL_UPLOAD = ROOTPATH + "/file/productRemoval/upload/";
    String FILE_PRODUCT_REMOVAL_DOWNLOAD = ROOTPATH + "/file/productRemoval/download/";
    /**
     * 产品去化模型Excel文件下载时的映射路径
     */
    String FILE_PRODUCTREMOVAL_DOWNLOAD_MAPPING = "/download/";
    /**
     * 产品参数保存Excel文件路径
     */
    String FILE_PRODUCT_PARAMETER_UPLOAD = ROOTPATH + "/file/productParameter/upload/";
    /**
     * 产品组合计算文件配置入路径
     */
    String FILE_COMBINATION_LOG_SAVE = ROOTPATH + "/log/result/";
    String FILE_COMBINATION_LOG_BACKUP = ROOTPATH + "/log/backup/";
    String FILE_COMBINATION_LOG_ERROR = ROOTPATH + "/log/error/";
    String FILE_COMBINATION_LOG_PROMPT = ROOTPATH + "/log/groupPrompt/";
    String FILE_COMBINATION_RAW_DATA = ROOTPATH + "/log/groupRawdata/";
    String FILE_COMBINATION_LOG_TEMPORARY = ROOTPATH + "/log/temporary/";

    /**
     * matlab计算数据缓存路径
     */
    String FILE_COMPUTATION_MATLAB_CACHE = ROOTPATH + "/file/matlab/cache/";
    String FILE_COMPUTATION_MATLAB_ALGORITHM = ROOTPATH + "/file/matlab/mathAlgorithm/";
    String FILE_COMPUTATION_MATLAB_ERROR = ROOTPATH + "/file/matlab/maxError/";
}
