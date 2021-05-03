package com.ipiecoles.batch.dbexport;

import com.ipiecoles.batch.entity.Commune;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileFooterCallback;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Footer implements FlatFileFooterCallback, ItemWriter<Commune> {

    @Override
    public void write(List<? extends Commune> list) throws Exception {
    }

    @Override
    public void writeFooter(Writer writer) throws IOException {
        writer.write("Total des communes : " + " " + Reference.countCommune);
    }
}
