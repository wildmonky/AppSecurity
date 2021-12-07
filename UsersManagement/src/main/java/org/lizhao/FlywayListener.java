package org.lizhao;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.lizhao.utils.database.DataBaseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;;import javax.sql.DataSource;

/**
 * //Description TODO
 *
 * @author lizhao
 * @version 1.0
 * @ClassName FlywayListener
 * @Date 2021-10-05 16:51
 * @since 1.8
 */
public class FlywayListener implements ApplicationListener<ContextStartedEvent> {

    private static Logger log= LoggerFactory.getLogger(FlywayListener.class);
    @Autowired
    DataSource dataSource;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {

        FluentConfiguration fluentConfiguration = Flyway.configure();
        fluentConfiguration.dataSource(dataSource);
        fluentConfiguration.table("APP_DB_SCRIPT_VER");

        try{//according to the database to choose sql script
            String db=DataBaseUtils.getDbType(dataSource);
            fluentConfiguration.locations("sql/"+db.substring(db.indexOf("_"))+"/");
            Flyway flyway = fluentConfiguration.load();
            flyway.baseline();
            flyway.migrate();
        }catch(java.sql.SQLException e){
            System.out.println(e);
            log.error("no database can be used to execute sql script",e);
        }

    }

}
