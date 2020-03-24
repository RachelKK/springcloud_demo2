import com.aistar.dao.DeptDao;
import com.aistar.dao.EmployeeDao;
import com.aistar.dao.impl.DeptDaoImpl;
import com.aistar.dao.impl.EmployeeDaoImpl;
import com.aistar.pojo.Dept;
import com.aistar.pojo.Employee;
import com.aistar.util.PageUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestEmp {
    EmployeeDao dao =  new EmployeeDaoImpl();


    @Test
    public void testSelectByPK(){
        Employee emp = dao.selectByPrimaryKey(7788);
        System.out.println(emp);
    }

    //测试分页查询
    @Test
    public void testSelectByPage(){


        // 模拟了service业务层
        int pagecode = 4;
        PageUtil<Employee> page = new PageUtil();
        page.setCurrentPage(pagecode);  //当前页码
        page.setStartRecode(pagecode * (page.getPageSize() -1) +1);
        page.setTotalSize(dao.count()); //总记录数
        int totalPages = page.getTotalSize() % page.getPageSize() == 0 ?  (page.getTotalSize() / page.getPageSize()):(page.getTotalSize() / page.getPageSize()+1);
        page.setTotalPages(totalPages);


        List<Employee> list = dao.selectByPage(page.getStartRecode(),page.getPageSize());



        page.setData(list);
        System.out.println(page);
    }

    @Test
    public void testInsert(){
        Employee employee = new Employee(8888,"纪娜","项目经理",7788,new Date(),5000,400,10);
        int rows = dao.insert(employee);
        System.out.println(rows);
    }

    @Test
    public void testDelete(){
        int rows = dao.delete(8888);
        System.out.println(rows);
    }

    @Test
    public void testUpdate(){
        Employee employee = dao.selectByPrimaryKey(8888);
        employee.setSalary(9999);
        employee.setComm(666.0f);

        int rows =  dao.update(employee);
        System.out.println(rows);

    }


}
