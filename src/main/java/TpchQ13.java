//import org.apache.flink.api.common.typeinfo.Types;
//import org.apache.flink.api.java.DataSet;
//import org.apache.flink.api.java.ExecutionEnvironment;
//import org.apache.flink.table.api.Table;
//import org.apache.flink.table.api.TableEnvironment;
//import org.apache.flink.table.api.java.BatchTableEnvironment;
//import org.apache.flink.table.sources.CsvTableSource;
//import org.apache.flink.types.Row;
//
//public class TpchQ13 {
//
//    public static void run(String[] args) throws Exception {
//        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
//        BatchTableEnvironment tEnv = TableEnvironment.getTableEnvironment(env);
//
//        CsvTableSource ordersTableSource = CsvTableSource.builder()
//                .path("/Users/zuozhiw/workspace/expriment/flink-experiment/orders.tbl")
////                .path("hdfs://texera-hdfs-2-m:8020/datasets/1G/lineitem.tbl")
//                .fieldDelimiter("|")
//                .field("o_orderkey", Types.INT)
//                .field("o_custkey", Types.INT)
//                .field("o_orderstatus", Types.STRING)
//                .field("o_totalprice", Types.FLOAT)
//                .field("o_orderdate", Types.STRING)
//                .field("o_orderpriority", Types.STRING)
//                .field("o_clerk", Types.STRING)
//                .field("o_shippriority", Types.INT)
//                .field("o_comment", Types.STRING)
//                .build();
//
//        CsvTableSource customerTableSource = CsvTableSource.builder()
//                .path("/Users/zuozhiw/workspace/expriment/flink-experiment/customer.tbl")
////                .path("hdfs://texera-hdfs-2-m:8020/datasets/1G/lineitem.tbl")
//                .fieldDelimiter("|")
//                .field("c_custkey", Types.INT)
//                .field("c_name", Types.STRING)
//                .field("c_address", Types.STRING)
//                .field("c_nationkey", Types.INT)
//                .field("c_phone", Types.STRING)
//                .field("c_acctbal", Types.FLOAT)
//                .field("c_mktsegment", Types.STRING)
//                .field("c_comment", Types.STRING)
//                .build();
//
//        tEnv.registerTableSource("customer", customerTableSource);
//
//        Table table = tEnv.scan("lineitem");
//        Table plan = table.filter("l_shipdate > '1991-01-01'")
//                .groupBy("l_returnflag")
//                .select("l_returnflag, sum(l_quantity) as l_quantity_sum").orderBy("l_returnflag");
//
//        DataSet<Row> result = tEnv.toDataSet(plan, Row.class);
//        result.print();
//    }
//}
