package com.github.tobato.fastdfs.sachin;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Sachin
 * @Date 2021/11/24
 **/
@Service
public class FdfsServiceImpl {


    @Autowired
    FastFileStorageClient fastFileStorageClient;


    public String upload(MultipartFile multipartFile, String fileExtName)throws  Exception{

        StorePath storePath = fastFileStorageClient.uploadFile (multipartFile.getInputStream (), multipartFile.getSize (), fileExtName, null);


        return storePath.getFullPath ();

    }


}
