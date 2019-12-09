package com.nc.util;

import org.springframework.web.multipart.MultipartFile;

/*其中 MultipartFile 类型的属性，用于接受上传文件的注入。
 *注：这里的属性名称image必须和页面的增加分类部分中的type="file"的name保持一致。
*/
public class UploadedImageFile {
	MultipartFile image;
	public MultipartFile getImage(){
		return image;
	}
	public void setImage(MultipartFile image){
		this.image = image;
	}
}
