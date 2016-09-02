/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlf.logic.execute;

import com.tlf.abstration.entities.Column;
import com.tlf.abstration.entities.Primary;
import com.tlf.abstration.entities.Table;
import com.tlf.logic.velocityUtil.VelocityUtil;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Crisitan Camilo Zapata Torres
 * @version 1.0.0
 * @see <a href="https://plus.google.com/u/0/117178818025238083388">Perfil</a>
 */
public class TempleteEntity {

    private VelocityUtil util;

    public TempleteEntity() {
        super();
        this.util = new VelocityUtil();
    }

    public void createEntity(List<Table> tables, List<Column> columns,List<Primary> primaries)
            throws FileNotFoundException {
        Map<String, Object> map = new HashMap<>();
        PrintStream salidatxt = null;
        for (Table table : tables) {
            List<Column> auxColumns = new ArrayList<>();
            List<Primary> auxPrimaries = new ArrayList<>();
            for (Column column : columns) {
                if (column.getTable() == table) {
                    auxColumns.add(column);
                }
            }
            for (Primary primary : primaries) {
                if (primary.getTable() == table) {
                    auxPrimaries.add(primary);
                }
            }
            try {
                map.put("table", table);
                map.put("columns", auxColumns);
                map.put("primaries", auxPrimaries);
                StringWriter writer = this.util.
                        executeTemplate("entity.vm", map, "templates");
                salidatxt = new PrintStream("test/"+table.getTableName() + ".java");
                salidatxt.println(writer.toString());
                System.out.println(writer.toString());
                //quitar el syso
                map.clear();
            } finally {
                salidatxt.close();
            }
        }
    }

}
