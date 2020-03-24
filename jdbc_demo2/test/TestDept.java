import com.aistar.dao.DeptDao;
import com.aistar.dao.impl.DeptDaoImpl;
import com.aistar.pojo.Dept;
import org.junit.Test;

import java.util.List;

public class TestDept {
    DeptDao dao =  new DeptDaoImpl();


    @Test
    public void testSelectByPK(){
        Dept dept = dao.selectByPrimaryKey(10);
        System.out.println(dept);
    }

    @Test
    public void testSelectAll(){
        List<Dept> deptList = dao.selectAll();
        for(Dept dept :deptList){
            System.out.println(dept);
        }
    }

    @Test
    public void testInsert(){
        Dept dept = new Dept(86,"产品部","北京");
       int rows =  dao.insert(dept);
        System.out.println(rows);
    }

    @Test
    public void testDelete(){
        int rows = dao.delete(99);
        System.out.println(rows);
    }

    @Test
    public void testUpdate(){
        Dept dept = dao.selectByPrimaryKey(10);  // 从数据库中查询出来的【 数据库中的数据   保持一致    内存dept 】
        dept.setDname("企划部");
        dept.setLoc("无锡");  // 数据库中的数据      内存dept  不一致

        int rows =  dao.update(dept); // 持久化 ： 内存中的数据  持久化到 数据库中
        System.out.println(rows);

    }




}
