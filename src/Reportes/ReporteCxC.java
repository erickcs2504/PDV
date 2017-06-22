/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;
import static java.awt.PageAttributes.MediaType.C;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperExportManager;
import java.io.File;

/**
 *
 * @author Erick Cordero
 */
public class ReporteCxC {

    public void CxC(Date pFechaUno, Date pFechaDos,String pTotal) throws SQLException, JRException{
        Connection a;
        a=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PDV","sa","egcs2504");
       // JasperReport reporte=null;
        //reporte=(JasperReport) JRLoader.loadObjectFromFile("src/Reportes/reporteCxC.jasper");
        JasperReport reporte=(JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/reporteCxC.jasper"));
        
        Map parametros=new HashMap();
        parametros.put("FECHA1",pFechaUno);
        parametros.put("FECHA2",pFechaDos);
        parametros.put("SALDO", pTotal);
        
        JasperPrint print=JasperFillManager.fillReport(reporte, parametros, a);
        //JasperExportManager.exportReportToPdfFile( print, "C:\\dist\\ReporteCxC.pdf");
        
        JasperViewer ver=new JasperViewer(print,false);
        ver.setTitle("Cuentas por Cobrar");
        ver.setVisible(true);
        
        
        
    }
    
}
