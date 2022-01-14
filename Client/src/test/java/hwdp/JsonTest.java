package hwdp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.geom.Rectangle2D;

public class JsonTest {
    @Test
    public void jss(){
        ObjectMapper objectMapper = new ObjectMapper();
        Rectangle2D.Double rec = new Rectangle2D.Double(10,10,10,10);
        MyShape shape = new MyShape(10,10,10,10);
        try{
            String json = objectMapper.writeValueAsString(shape);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //assertNotNull(json);
    }
}
