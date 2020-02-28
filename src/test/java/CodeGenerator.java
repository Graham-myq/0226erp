import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();// 代码生成器
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());// 选择 freemarker 引擎，默认 Veloctiy
        //mpg.setTemplateEngine(new BeetlTemplateEngine()); //Beetl
        GlobalConfig gc = new GlobalConfig();// 全局配置
        final String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java"); // 获取用户程序当前路径（项目根的路径）
        //gc.setOutputDir("D://workspace/spring-boot-mybatis/src/main/java");//可以指定生成路径
        gc.setFileOverride(true); // 是否覆盖同名文件，默认是false
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// // mapper映射文件是否生成BaseResultMap
        gc.setBaseColumnList(false);//  XML 是否生成BaseColumn
        /* 自定义文件命名，注意 %s 会自动填充表实体属性！ */
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        gc.setAuthor("myq"); //开发人员(默认值：null)
        gc.setOpen(false);// 是否打开输出目录(默认值：null)
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);//把全局配置添加到代码生成器主类

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/0520erp?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=utf8");
        //dsc.setSchemaName("public");// 数据库 schema name(例如 PostgreSQL 可指定为 public)
        dsc.setDbType(DbType.MYSQL);// 数据库类型
        dsc.setDriverName("com.mysql.jdbc.Driver");// 驱动名称
        dsc.setUsername("root");//用户名
        dsc.setPassword("root");//密码
        mpg.setDataSource(dsc);

        // 包配置
        final PackageConfig pc = new PackageConfig();
        //pc.setModuleName("foundation");// 父包模块名
        pc.setParent("com.sxt.sys");// 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setService("service");// Service包名
        pc.setEntity("pojo");// Entity包名
        pc.setServiceImpl("service.impl");// ServiceImpl包名
        pc.setMapper("mapper");// Mapper包名
        pc.setController("controller");// Contoller包名
        // pc.setXml("mapper.xml");// Mapper.xml包名
        mpg.setPackageInfo(pc);// 把包配置添加到代码生成器主类

        // 自定义配置
        /*InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };*/

        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        //List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 自定义配置会被优先输出
        //focList.add(new FileOutConfig(templatePath) {
         /*   @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });*/
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        //cfg.setFileOutConfigList(focList);
        //mpg.setCfg(cfg);

        // 配置模板
        //TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        //templateConfig.setXml(null);
        //mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 数据库表映射到实体的命名策略:下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);// 【实体】是否为lombok模型（默认 false）
        strategy.setRestControllerStyle(true);// 生成 @RestController 控制器
        // 公共父类
       // strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        //strategy.setSuperEntityColumns("id");// 写于父类中的公共字段
        //strategy.setExclude("m_fnd_user1");// 需要排除的表名，允许正则表达式,表名，多个英文逗号分割
        strategy.setControllerMappingHyphenStyle(true);// 驼峰转连字符
        strategy.setEntityTableFieldAnnotationEnable(true);// 是否生成实体时，生成字段注解 默认false;
        strategy.setTablePrefix(pc.getModuleName() + "_");// 表前缀
        mpg.setStrategy(strategy);// 把策略配置添加到代码生成器主类
        mpg.execute();
    }

}
