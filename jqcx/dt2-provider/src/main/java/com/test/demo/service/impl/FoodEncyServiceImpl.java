package com.test.demo.service.impl;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.test.demo.mapper.FoodEncyMapper;
import com.test.demo.model.FoodEncy;
import com.test.demo.service.FoodEncyService;
import com.xm.xmap1702044.base.PageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xuzhiyuan
 * @create 2018年7月17日17:03:32
 * @desc
 **/
@Service(value = "FoodEncyService")
public class FoodEncyServiceImpl extends SuperServiceImpl<FoodEncyMapper,FoodEncy> implements FoodEncyService {

@Autowired
private FoodEncyMapper foodEncyMapper;
        @Override
        public List<FoodEncy> queryType(String type) {
                List<FoodEncy> list = null;

                try{
                        list=foodEncyMapper.queryType(type);
//                        if(list.size()>0){
//                                for(int i=0;i<list.size();i++){
//                                        // String str =convertBlobToBase64String(list.get(i).getPicture());
//                                        //list.get(i).setFoodPic(str);
//                                        String str= replaceBlank(list.get(i).getPicture());
//                                        String base64Str = (new sun.misc.BASE64Encoder()).encode(str.getBytes());
//                                        list.get(i).setFoodPic(base64Str);
//                                }
//                        }

                }catch(Exception e){
                       e.printStackTrace();
                }
                return list;
        }

        /**
         * 去掉空格回车换行符
         * @param str
         * @return
         */
        public static String replaceBlank(String str) {
                String dest = "";
                if (str!=null) {
                        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                        Matcher m = p.matcher(str);
                        dest = m.replaceAll("");
                }
                return dest;
        }

        /**
         * blob类型转base64
         *
         * @param blob
         * @return
         */
        public static String convertBlobToBase64String(Blob blob) {
                String result = "";
                if(null != blob) {
                        try {
                                InputStream msgContent = blob.getBinaryStream();
                                ByteArrayOutputStream output = new ByteArrayOutputStream();
                                byte[] buffer = new byte[100];
                                int n = 0;
                                while (-1 != (n = msgContent.read(buffer))) {
                                        output.write(buffer, 0, n);
                                }
                                result =new BASE64Encoder().encode(output.toByteArray()) ;
                                output.close();
                        } catch (SQLException e) {
                                e.printStackTrace();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                        return result;
                }else {
                        return null;
                }
        }
        @Override
        public PageManager query(FoodEncy foodEncy, PageManager page) {
                return null;
        }

        @Override
        public FoodEncy get(FoodEncy foodEncy) {
                return null;
        }

        @Override
        public int save(FoodEncy foodEncy) {
                return 0;
        }

        @Override
        public int update(FoodEncy foodEncy) {
                return 0;
        }

        @Override
        public int delete(FoodEncy foodEncy) {
                return 0;
        }
}
