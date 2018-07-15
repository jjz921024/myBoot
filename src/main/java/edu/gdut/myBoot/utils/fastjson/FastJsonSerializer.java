package edu.gdut.myBoot.utils.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import edu.gdut.myBoot.utils.Serializer;
import org.springframework.stereotype.Component;


/**
 * Created by chenyangli.
 */
@Component
public class FastJsonSerializer implements Serializer {

    public byte[] serialize(Object object) {
        byte[] bytes = JSON.toJSONBytes(object, SerializerFeature.SortField);
        return bytes;
    }

    /**
     * Be careful: using fastjson v1.2.7(now v1.2.17) cannot deserialize the object with class fields.
     *
     * @param bytes
     * @param clazz
     * @return
     */
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        T result = JSON.parseObject(bytes, clazz, Feature.SortFeidFastMatch);
        return result;
    }
}
