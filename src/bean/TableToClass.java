package bean;

import java.sql.ResultSet;

/**
 * @program: homework
 * @Date: 2019/5/23 11:19
 * @Author: 黄文威
 * @Description:
 */
public interface TableToClass{
	Object tableToClass(ResultSet resultSet);
}
