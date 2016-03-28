package cxf.simplejaxwsservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import javax.xml.bind.annotation.adapters.XmlAdapter;
 
/**
 * @author RRached
 *
 */
public abstract class IntegerUserMapAdapter extends XmlAdapter<IntegerUserType, Map<Integer, User> > {
 @Override
 public IntegerUserType marshal(Map<Integer, User> map) throws Exception {
   return new IntegerUserType(map);
 }
 
 @Override
 public Map<Integer, User> unmarshal(IntegerUserType type) throws Exception {
   Map map = new HashMap();
   List<IntegerUser> users = type.getUsers();
   for (IntegerUser idUser : users) {
      map.put(idUser.getId(), idUser.getUser());
   }
   return map;
 }
}
