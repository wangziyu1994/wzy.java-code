package com.wang.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.batch.api.listener.JobListener;
import javax.swing.plaf.multi.MultiFileChooserUI;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobListenerFactoryBean;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.batch.item.database.support.SqlitePagingQueryProvider;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.validation.BindException;

import com.wang.model.CreditBill;

@Configuration
public class MyJob1 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    //@Value("#{jobExecutionContext['fileName']}")
    private String fileName;


    @Autowired
    private FilePaths fps;


    @Bean(name = "myjob1")
    public Job getMyjob1(//@Qualifier("mystep1") Step step1,
                        // @Qualifier("mystep2") Step step2,
                         //@Qualifier("mystep3") Step step3,
                         @Qualifier("mystep4") Step step4,
                         @Qualifier("jl") JobExecutionListener jl) {
        return jobBuilderFactory.get("myjob1")
                .incrementer(new RunIdIncrementer())
                .listener(jl)
                .flow(step4).build()
              /*  .from(step1).on("success").to(step2)
                .on("FAILED").end()*/
                /*.from(step2).on("COMPLETED").to(step3)
                .on("FAILED").end()*/
                .build();
    }


    @Bean(name = "mystep1")
    public Step getMystep1(@Qualifier("tl1") Tasklet tl,
                           @Qualifier("sl1") StepExecutionListener st1) {
        return stepBuilderFactory.get("mystep1-1")
                .tasklet(tl)
                .listener(st1)
                .build();
    }


   // @Bean(name = "mystep2")
    public Step getMystep2(@Qualifier("fileReaders") MultiResourceItemReader<CreditBill> mm,
                           @Qualifier("pp") ItemProcessor mp,
                           @Qualifier("mw") ItemWriter mw,
                           @Qualifier("sl2") StepExecutionListener st2) {
        return stepBuilderFactory.get("mystep2-2")
                .listener(st2)
                .chunk(10)
                .reader(mm)
                .processor(mp)
                .writer(mw)
                .build();
    }

    //@Bean(name = "mystep3")
    public Step getMystep3(@Qualifier("fileReaders") MultiResourceItemReader<CreditBill> mm,
                           @Qualifier("pp") ItemProcessor mp,
                           @Qualifier("mw") ItemWriter mw,
                           @Qualifier("sl3") StepExecutionListener st3) {
        return stepBuilderFactory.get("mystep3-3")
                .listener(st3)
                .chunk(10)
                .reader(mm)
                .writer(mw)
                .build();
    }

    @Bean(name = "mystep4")
    public Step getMystep3(@Qualifier("MyItemReader2") ItemReader mm,
                           @Qualifier("MyItemWriter2") ItemWriter mw,
                           @Qualifier("sl4") StepExecutionListener st4
    ) {
        return stepBuilderFactory.get("mystep4-4")
                .listener(st4)
                .chunk(100)
                .reader(mm)
                .writer(mw)
                .build();
    }

    //@Bean(name = "fileReaders")
    @StepScope
    public MultiResourceItemReader<CreditBill> getMultiResources
            (@Qualifier("fileReader") FlatFileItemReader<CreditBill> flatFileItemReader,
             @Qualifier("mystep2") Step step,
             @Qualifier("sl2") MyStepListener2 st2,
             @Autowired StepConfiguration s) {
        MultiResourceItemReader<CreditBill> mm = new MultiResourceItemReader<CreditBill>();
        String fileName = st2.fileName;
        String fileName1 = st2.fileName1;
        //ExecutionContext es=new ExecutionContext();

        //se.getJobExecution();
        //String esName=es.getString("fileNames");
        System.out.println("传递过来的Jobexcution执行参数" + "是" + fileName);
        System.out.println("传递过来的Jobexcution执行参数" + "是" + fileName1);
        // System.out.println("传递过来的Jobexcution执行参数"+"是"+this.fileName);
        System.out.println("传递过来的Jobexcution执行参数" + "是" + s);
        //System.out.println("传递过来的Jobexcution执行参数"+"是"+esName);

        String files[] = fps.getFilePath();
        String fd = fps.getFileDirectory();
        Resource resources[] = new Resource[files.length];

        for (int i = 0; i <= files.length - 1; i++) {
            FileSystemResource fs = new FileSystemResource(fd + "\\" + files[i]);
            resources[i] = fs;

        }
        mm.setResources(resources);
        mm.setDelegate(flatFileItemReader);

        return mm;

    }


    /*
     * @Bean(name="mystep3") public Step getMystep3( ) { return
     * stepBuilderFactory.get("mystep3") .tasklet(tasklet) }
     */


    @Bean(name = "fileReader")
    @StepScope
    public FlatFileItemReader<CreditBill> getSingleFileItemReader(@Qualifier("lm") MyLineMapper ml) {
        FlatFileItemReader<CreditBill> f = new FlatFileItemReader();
        f.setEncoding("UTF-8");

        /*
         * DefaultLineMapper<CreditBill> d=new DefaultLineMapper();
         * DelimitedLineTokenizer t=new DelimitedLineTokenizer(); t.setDelimiter(",");
         * t.setNames(new String[] {"","","",""}); d.setLineTokenizer(t);
         * d.setFieldSetMapper(new FieldSetMapper(){
         *
         * public CreditBill mapFieldSet(FieldSet fieldSet) throws BindException {
         * CreditBill c=new CreditBill(); c.setName(fieldSet.readString("")); return c;
         * }
         *
         * });
         */
        f.setLineMapper(ml);

        return f;

    }


    public SimpleAsyncTaskExecutor getThread1() {
        return new SimpleAsyncTaskExecutor();
    }

}
