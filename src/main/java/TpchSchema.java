//import org.apache.spark.sql.types.DataTypes;
//import org.apache.spark.sql.types.StructField;
//import org.apache.spark.sql.types.StructType;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TpchSchema {
//
//    // l_orderkey bigint ,
//    // l_partkey bigint ,
//    // l_suppkey bigint ,
//    // l_linenumber bigint ,
//    // l_quantity FLOAT,
//    // l_extendedprice FLOAT,
//    // l_discount FLOAT,
//    // l_tax FLOAT,
//    // l_returnflag STRING ,
//    // l_linestatus STRING ,
//    // l_shipdate STRING ,
//    // l_commitdate STRING ,
//    // l_receiptdate STRING ,
//    // l_shipinstruct STRING,
//    // l_shipmode STRING,
//    // l_comment STRING
//    public static List<StructField> lineItemFields = new ArrayList<>();
//    static {
//        lineItemFields.add(DataTypes.createStructField("l_orderkey", DataTypes.IntegerType, false));
//        lineItemFields.add(DataTypes.createStructField("l_partkey", DataTypes.IntegerType, false));
//        lineItemFields.add(DataTypes.createStructField("l_suppkey", DataTypes.IntegerType, false));
//        lineItemFields.add(DataTypes.createStructField("l_linenumber", DataTypes.IntegerType, false));
//        lineItemFields.add(DataTypes.createStructField("l_quantity", DataTypes.FloatType, false));
//        lineItemFields.add(DataTypes.createStructField("l_extendedprice", DataTypes.FloatType, false));
//        lineItemFields.add(DataTypes.createStructField("l_discount", DataTypes.FloatType, false));
//        lineItemFields.add(DataTypes.createStructField("l_tax", DataTypes.FloatType, false));
//        lineItemFields.add(DataTypes.createStructField("l_returnflag", DataTypes.StringType, false));
//        lineItemFields.add(DataTypes.createStructField("l_linestatus", DataTypes.StringType, false));
//        lineItemFields.add(DataTypes.createStructField("l_shipdate", DataTypes.StringType, false));
//        lineItemFields.add(DataTypes.createStructField("l_commitdate", DataTypes.StringType, false));
//        lineItemFields.add(DataTypes.createStructField("l_receiptdate", DataTypes.StringType, false));
//        lineItemFields.add(DataTypes.createStructField("l_shipinstruct", DataTypes.StringType, false));
//        lineItemFields.add(DataTypes.createStructField("l_shipmode", DataTypes.StringType, false));
//        lineItemFields.add(DataTypes.createStructField("l_comment", DataTypes.StringType, false));
//    }
//    public static final StructType lineItemSchema = DataTypes.createStructType(lineItemFields);
//
//    // o_orderkey BIGINT,
//    // o_custkey BIGINT,
//    // o_orderstatus STRING,
//    // o_totalprice FLOAT,
//    // o_orderdate STRING,
//    // o_orderpriority STRING,
//    // o_clerk STRING,
//    // o_shippriority INT,
//    // o_comment STRING
//    public static List<StructField> ordersFields = new ArrayList<>();
//    static {
//        ordersFields.add(DataTypes.createStructField("o_orderkey", DataTypes.IntegerType, false));
//        ordersFields.add(DataTypes.createStructField("o_custkey", DataTypes.IntegerType, false));
//        ordersFields.add(DataTypes.createStructField("o_orderstatus", DataTypes.StringType, false));
//        ordersFields.add(DataTypes.createStructField("o_totalprice", DataTypes.FloatType, false));
//        ordersFields.add(DataTypes.createStructField("o_orderdate", DataTypes.StringType, false));
//        ordersFields.add(DataTypes.createStructField("o_orderpriority", DataTypes.StringType, false));
//        ordersFields.add(DataTypes.createStructField("o_clerk", DataTypes.StringType, false));
//        ordersFields.add(DataTypes.createStructField("o_shippriority", DataTypes.IntegerType, false));
//        ordersFields.add(DataTypes.createStructField("o_comment", DataTypes.StringType, false));
//    }
//    public static final StructType ordersSchema = DataTypes.createStructType(ordersFields);
//
//
//
//    // c_custkey BIGINT,
//    // c_name STRING,
//    // c_address STRING,
//    // c_nationkey INT,
//    // c_phone STRING,
//    // c_acctbal FLOAT,
//    // c_mktsegment STRING,
//    // c_comment STRING
//    public static List<StructField> customerFields = new ArrayList<>();
//    static {
//        customerFields.add(DataTypes.createStructField("c_custkey", DataTypes.IntegerType, false));
//        customerFields.add(DataTypes.createStructField("c_name", DataTypes.StringType, false));
//        customerFields.add(DataTypes.createStructField("c_address", DataTypes.StringType, false));
//        customerFields.add(DataTypes.createStructField("c_nationkey", DataTypes.IntegerType, false));
//        customerFields.add(DataTypes.createStructField("c_phone", DataTypes.StringType, false));
//        customerFields.add(DataTypes.createStructField("c_acctbal", DataTypes.FloatType, false));
//        customerFields.add(DataTypes.createStructField("c_mktsegment", DataTypes.StringType, false));
//        customerFields.add(DataTypes.createStructField("c_comment", DataTypes.StringType, false));
//    }
//    public static final StructType customerSchema = DataTypes.createStructType(customerFields);
//
//
//}
