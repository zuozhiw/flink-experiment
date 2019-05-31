import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.api.java.BatchTableEnvironment;
import org.apache.flink.table.sources.CsvTableSource;
import org.apache.flink.types.Row;

import java.text.DecimalFormat;
import java.util.List;

public class TpchQ13 {

    public static void run(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        BatchTableEnvironment tEnv = TableEnvironment.getTableEnvironment(env);

        CsvTableSource ordersTableSource = CsvTableSource.builder()
//                .path("/Users/zuozhiw/workspace/expriment/flink-experiment/orders.tbl")
                .path("hdfs://texera-hdfs-2-m:8020/datasets/1G/orders.tbl")
                .fieldDelimiter("|")
                .field("o_orderkey", Types.INT)
                .field("o_custkey", Types.INT)
                .field("o_orderstatus", Types.STRING)
                .field("o_totalprice", Types.FLOAT)
                .field("o_orderdate", Types.STRING)
                .field("o_orderpriority", Types.STRING)
                .field("o_clerk", Types.STRING)
                .field("o_shippriority", Types.INT)
                .field("o_comment", Types.STRING)
                .build();

        CsvTableSource customerTableSource = CsvTableSource.builder()
//                .path("/Users/zuozhiw/workspace/expriment/flink-experiment/customer.tbl")
                .path("hdfs://texera-hdfs-2-m:8020/datasets/1G/customer.tbl")
                .fieldDelimiter("|")
                .field("c_custkey", Types.INT)
                .field("c_name", Types.STRING)
                .field("c_address", Types.STRING)
                .field("c_nationkey", Types.INT)
                .field("c_phone", Types.STRING)
                .field("c_acctbal", Types.FLOAT)
                .field("c_mktsegment", Types.STRING)
                .field("c_comment", Types.STRING)
                .build();

        tEnv.registerTableSource("orders", ordersTableSource);
        tEnv.registerTableSource("customer", customerTableSource);


        Table orders = tEnv.scan("orders");
        Table customer = tEnv.scan("customer");

        Table plan = orders.join(customer, "o_custkey = c_custkey")
                .groupBy("o_custkey")
                .select("o_custkey, count(o_orderkey) as c_count")
                .groupBy("c_count")
                .select("c_count, count(o_custkey) as cnt")
                .orderBy("c_count");

        DataSet<Row> dataSet = tEnv.toDataSet(plan, Row.class);

        long start = System.currentTimeMillis();

        List<Row> resultRows = dataSet.collect();

        System.out.println("result count: " + resultRows.size());
        for (Row row: resultRows) {
            System.out.println(row);
        }

        long end = System.currentTimeMillis();

        System.out.println("time: " + new DecimalFormat("#.##").format(((double) end - start) / 1000) + " seconds");

    }
}
