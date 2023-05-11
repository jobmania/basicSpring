package com.demo.service;

import com.demo.beans.ContentBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

    @Value("${path.upload}")
    private String path_upload;



    //서버로 업로드 된 파일을 업로드 폴더에 저장하고 파일의 이름을 리턴하는 메소드
    private String saveUploadFile(MultipartFile upload_file) {

        //현재 시간(밀리세컨드)을 이용해서 파일의 이름이 중복되지 않게 설정
//        String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String file_name = uuid.toString() + "_" + upload_file.getOriginalFilename();

        try {
            upload_file.transferTo(new File(path_upload + "/" + file_name));
        }catch(Exception e) {
            e.printStackTrace();
        }

        return file_name;
    }




    public void addContentInfo(ContentBean writeContentBean) {

        MultipartFile upload_file = writeContentBean.getUpload_file();

        if(upload_file.getSize() > 0) {
            String file_name = saveUploadFile(upload_file);
            writeContentBean.setContent_file(file_name);
        }
    }
}
