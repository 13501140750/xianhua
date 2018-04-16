package com.jifenbao.common;

public class CKFinderImagePathTools {

    public static void main(String[] args0){
        String thumb = "D:/project/jifenbao/trunk/workspace/jifenbao-admin/src/main/webapp/CKFinderJava/userfiles/_thumbs/Images";
        String image = "D:/project/jifenbao/trunk/workspace/jifenbao-admin/src/main/webapp/CKFinderJava/userfiles/images";
        
        System.out.println(CKFinderImagePathTools.getThumbPath(image));
        System.out.println(image.replace("images", "_thumbs/Images").equals(thumb));
    }
    
    public static String getThumbPath(String imagePath){
        if(imagePath == null){
            return null;
        }
        return imagePath.replace("images", "_thumbs/Images");
    }
}
