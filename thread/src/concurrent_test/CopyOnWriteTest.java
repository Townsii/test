package concurrent_test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写的效率非常低，读的效率非常高
 * 每次写入后都会复制一份用于读
 */
public class CopyOnWriteTest {

    List list = new CopyOnWriteArrayList<>();

}
