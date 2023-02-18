package com.radzik.michal.shop.config;

import com.radzik.michal.shop.batch.ProductProcessorImpl;
import com.radzik.michal.shop.batch.ProductReaderImpl;
import com.radzik.michal.shop.batch.ProductWriterImpl;
import com.radzik.michal.shop.batch.domain.ProductCsv;
import com.radzik.michal.shop.domain.dao.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final ProductReaderImpl productReader;

    private final ProductWriterImpl productWriter;

    private final ProductProcessorImpl productProcessor;

    public Job csvToDatabaseJob (String fileName){
        return jobBuilderFactory.get("csvJob")
                .incrementer(new RunIdIncrementer())
                .flow(csvToDatabaseFlow(fileName))
                .end().build();
    }

    private Step csvToDatabaseFlow(String fileName) {
    return stepBuilderFactory.get("csvStep")
            .<ProductCsv, Product>chunk(100)
            .reader(productReader.reader(fileName))
            .processor(productProcessor)
            .writer(productWriter)
            .taskExecutor(createTaskExecutor())
            .build();
    }

    private TaskExecutor createTaskExecutor() {
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor("Batch");
        simpleAsyncTaskExecutor.setConcurrencyLimit(5);
        return simpleAsyncTaskExecutor;
    }
}
