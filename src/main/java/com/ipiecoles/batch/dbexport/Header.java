package com.ipiecoles.batch.dbexport;

import com.ipiecoles.batch.entity.Commune;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileHeaderCallback;

import java.io.IOException;
import java.io.Writer;
import java.util.List;


public class Header implements FlatFileHeaderCallback , ItemWriter<Commune> , StepExecutionListener {

    Long countCp = null;
    Long countCommune = null;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void write(List<? extends Commune> list) throws Exception {
    }

    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write("Total des codes postaux : " + Reference.countCp);
    }

    @Override
    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        JobExecution jobExecution = stepExecution.getJobExecution();
        ExecutionContext jobContext = jobExecution.getExecutionContext();
        this.countCp = jobContext.getLong("countCp");
        this.countCommune = jobContext.getLong("countCommune");
    }

    @Override
    @AfterStep
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
