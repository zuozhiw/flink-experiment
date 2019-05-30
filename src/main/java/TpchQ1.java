import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.api.java.BatchTableEnvironment;
import org.apache.flink.table.sources.CsvTableSource;
import org.apache.flink.types.Row;

public class TpchQ1 {

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        BatchTableEnvironment tEnv = TableEnvironment.getTableEnvironment(env);

        CsvTableSource lineitemTableSource = CsvTableSource.builder()
//                .path("/Users/zuozhiw/workspace/expriment/flink-experiment/lineitem.tbl")
                .path("hdfs://texera-hdfs-2-m:8020/datasets/1G/lineitem.tbl")
                .fieldDelimiter("|")
                .field("l_orderkey", Types.INT)
                .field("l_partkey", Types.INT)
                .field("l_suppkey", Types.INT)
                .field("l_linenumber", Types.INT)
                .field("l_quantity", Types.FLOAT)
                .field("l_extendedprice", Types.FLOAT)
                .field("l_discount", Types.FLOAT)
                .field("l_tax", Types.FLOAT)
                .field("l_returnflag", Types.STRING)
                .field("l_linestatus", Types.STRING)
                .field("l_shipdate", Types.STRING)
                .field("l_commitdate", Types.STRING)
                .field("l_receiptdate", Types.STRING)
                .field("l_shipinstruct", Types.STRING)
                .field("l_shipmode", Types.STRING)
                .field("l_comment", Types.STRING).build();

        tEnv.registerTableSource("lineitem", lineitemTableSource);

        Table table = tEnv.scan("lineitem");
        Table plan = table.filter("l_shipdate > '1991-01-01'")
                .groupBy("l_returnflag")
                .select("l_returnflag, sum(l_quantity) as l_quantity_sum").orderBy("l_returnflag");

        DataSet<Row> result = tEnv.toDataSet(plan, Row.class);
        result.print();
    }
}
