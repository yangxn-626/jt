package com.jt.service;

import com.jt.vo.ImageVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
@PropertySource("classpath:/properties/image.properties")
public class FileServiceImpl implements FileService{
    @Value("${image.localDirPath}")
    private String localPath;
    @Value("${image.urlPath}")
    private String urlPaht ;
    @Override
    public ImageVO updateFile(MultipartFile uploadFile) {
        ImageVO imageVO = new ImageVO();
        String fileName = uploadFile.getOriginalFilename();
        fileName = fileName.toLowerCase();
        if(!fileName.matches("^.+\\.(jpg|png|gif)$")){
            imageVO.setError(1);
            return imageVO;
        }
        try {
            BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            if(width==0||height==0){
                imageVO.setError(1);
                return imageVO;
            }
            String dateDir = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            String localDir = localPath + dateDir;
            File dirDile = new File(localDir);
            if(!dirDile.exists()){
                dirDile.mkdirs();
            }
            String uuid = UUID.randomUUID().toString().replace("-","");
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            String realLocalPath = localDir + "/" + uuid + fileType;
            uploadFile.transferTo(new File(realLocalPath));
            String realUrlPath = urlPaht + dateDir + "/" + uuid + fileType;
            imageVO.setError(0).setHeight(height).setWidth(width).setUrl(realUrlPath);
        }catch (Exception e){
            e.printStackTrace();
            imageVO.setError(1);
            return imageVO;
        }
        return imageVO;
    }
}
