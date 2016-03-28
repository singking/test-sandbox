package cxf.simplejaxwsservice;




import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
 
/**
 * https://mycenes.wordpress.com/2009/10/27/apache-cxf-how-tos-well-not-exactly/
 * @author RRached
 *
 */
@XmlType(name="IntegerUserType")
@XmlAccessorType(XmlAccessType.FIELD)
public class IntegerUserType {
 // produce a wrapper XML element around this collection
 @XmlElementWrapper(name="userList")
 // map each member of this list to an XML element named appointment
 @XmlElement(name="users")
 private List<IntegerUser> users;
 /**
  *
  */
 public IntegerUserType() {}
 /**
  * @param map
  */
 public IntegerUserType(Map<Integer, User> map) {
   users = new ArrayList();
   Set<Entry<Integer, User>> set = map.entrySet();
   for (Entry<Integer, User> idUserEntry : set) {
      users.add(new IntegerUser(idUserEntry.getKey(), idUserEntry.getValue()));
   }
 }
 /**
  * @return the users
  */
 public List<IntegerUser> getUsers() {
   return users;
 }

}