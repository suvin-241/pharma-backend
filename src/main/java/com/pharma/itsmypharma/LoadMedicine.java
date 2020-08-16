package com.pharma.itsmypharma;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("all")
public class LoadMedicine {

	public static String PadLeft(String stringToPad, int padToLength) {
		String retValue = null;
		if (stringToPad.length() < padToLength) {
			retValue = String.format("%0" + String.valueOf(padToLength - stringToPad.length()) + "d%s", 0, stringToPad);
		} else {
			retValue = stringToPad;
		}
		return retValue;
	}

	public static String getAmount(String amount) {
		if (amount == null)
			return null;

		char[] arr = amount.toCharArray();
		int i = 0;
		boolean flag=false;
		for (char c : arr) {
                i++;
			if (Character.isDigit(c)) {
				flag=true;
				break;
			}
		}
		return flag?amount.substring(i, amount.length()):null;
	}

	public static void main(String a[]) throws SQLException, IOException {

		//final String DB_URL = "jdbc:mysql://database-1.cvupt0lnxqwj.us-east-2.rds.amazonaws.com:3306/mypharma?useSSL=false&useUnicode=yes&characterEncoding=UTF-8";
		
		final String DB_URL = "jdbc:mysql://164.52.200.170:3306/itsmypharma?useSSL=false&useUnicode=yes&characterEncoding=UTF-8";

		// Database credentials
		//final String USER = "admin";
		//final String PASS = "itsmypharma012";
		final String USER = "pharma";
		final String PASS = "HGUT^%@gyfd7";
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2=null;
		PreparedStatement stmt3=null;
		PreparedStatement stmt4=null;
		Workbook workbook=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.print("\nConnecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
			
			System.out.println("connected");
			//File folder = new File("/Users/suvins/MyPharma/Pharmacy databse/MedicineData_A.xlsx");
			//File photoFolder=new File("/Users/suvins/MyPharma/Pharmacy Images/drugImages_A/drugs/");
			// File[] listOfFiles = folder.listFiles();
			AtomicLong rownum = new AtomicLong(18284);
			AtomicLong imageRownum=new AtomicLong(4089);
			// for (File f : listOfFiles) {s
			
			for(Map.Entry<String, String> s:folderMap.entrySet())
			{
				File folder = new File(folderMap.get(s.getKey()));
				File photoFolder = new File(photoMap.get(s.getKey()));
				
				System.out.println(folder.getAbsolutePath());
				System.out.println(photoFolder.getAbsolutePath());

				
				FileInputStream excelFile = new FileInputStream(folder);

				workbook = new XSSFWorkbook(excelFile);
				System.out.println("loaded");
				Sheet datatypeSheet = workbook.getSheetAt(0);
				System.out.println("Got sheet 0");
				Iterator<Row> iterator = datatypeSheet.iterator();
				int i = 0;
				String cellpathanme = null;
			stmt = conn.prepareStatement("insert into pharma_medi_mast(pmm_medi_id,"
					+ " pmm_drug_name,"
					+ " pmm_composition,"
					+ " pmm_manufact, "
					+ "pmm_mrp,"
					+ " pmm_price,"
					+ " pmm_package_vol, "
					+ "pmm_presc_type,"
					+ " pmm_medi_use, "
					+ "pmm_how_use, "
					+ "pmm_safety_advice,"
					+ " pmm_alter_brand,"
					+ " pmm_related_product,"
					+ " pmm_manufact_addr,pmm_image_path ,pmm_image_avail ) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt2=conn.prepareStatement("insert into pharma_medi_info(pmi_med_id,"
					+ " pmi_into_desc, "
					+ "pmi_side_effects,"
					+ " pmi_how_cope, "
					+ "pmi_how_work,"
					+ " pmi_if_forgot,"
					+ " pmi_expert_advice,"
					+ " pmi_interaction_drug, "
					//+ "pmi_patient_concern,"
					+ " pmi_feedback,"
					+ " pmi_ayurvedic_ingreden, "
					+ "pmi_related_lab_test,"
					//+ " pmi_faq, "
					+ "pmi_reference,"
					+ " pmi_vendor_partner) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			stmt3=conn.prepareStatement("insert into pharma_medi_images(pmi_image_id, pmi_medi_id, pmi_image) values(?,?,?)");
			stmt4=conn.prepareStatement("insert into pharma_medi_faq(pmf_medi_id,pmf_faq,pmf_patient_concern) values(?,?,?)");
			boolean flag=false;
			while (iterator.hasNext()) {
				
				

				Row currentRow = iterator.next();
				
				if (i == 0) {
					i++;
					System.out.println("continue");
					continue;
				}
				
				
				if (flag)
					break;
//			i++;
//				if (i ==112) {
//					break;
//				}
				
				

				int j = 1;
				String primarykey=PadLeft(String.valueOf(rownum.getAndIncrement()), 8);
				if(!flag)
				{
				stmt.setString(1, primarykey);
				stmt2.setString(1, primarykey);
			    stmt4.setString(1, primarykey);
				}
				
					for(int z=0;z<28;z++)
					{

					Cell currentCell = currentRow.getCell(z);

					switch (j) {
					case 1:
						flag=currentCell==null? true:false; 
						if(flag)
							break;
						stmt.setString(2,currentCell==null? null: currentCell.getStringCellValue());
						System.out.println("Medicine name"+currentCell==null? null: currentCell.getStringCellValue());//Azinet 200 Oral Suspension
						j++;
						break;
					case 2:
						stmt.setString(3, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 3:
						stmt.setString(4, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 4:
						if(currentCell!=null)
						{
							System.out.println(currentCell.getCellType());
						}
						stmt.setString(5, getAmount(currentCell==null? null:currentCell.getStringCellValue()));
						j++;
						break;
					case 5:
						stmt.setString(6, getAmount(currentCell==null? null:currentCell.getStringCellValue()));
						j++;
						break;
					case 6:
						stmt.setString(7, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 7:
						String tempValue=null;
						if(currentCell==null || "Prescription Not found".equalsIgnoreCase(currentCell.getStringCellValue())) {
							tempValue="NA";
						}
						else if("Prescription Required".equalsIgnoreCase(currentCell.getStringCellValue()))
						{
							tempValue="Y";
						}
						else {
							tempValue="N";
						}
						stmt.setString(8,tempValue);
						j++;
						break;
					case 8:
						stmt2.setString(2, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 9:
						stmt.setString(9, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 10:
						stmt2.setString(3, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 11:
						stmt2.setString(4, currentCell==null? null:currentCell.getStringCellValue());
						//if(currentCell!=null && currentCell.getStringCellValue().length() >8000)
						//System.out.println("cope length:"+ (currentCell==null? null:currentCell.getStringCellValue().length()));
						j++;
						break;
					case 12:
						stmt.setString(10, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 13:
						stmt2.setString(5, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 14:
						stmt.setString(11, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 15:
						stmt2.setString(6, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 16:
						stmt2.setString(7, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 17:
						stmt.setString(12, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 18:
						stmt2.setString(8, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 19:
						stmt4.setString(3, currentCell==null? null:currentCell.getStringCellValue());
						//System.out.println("concern lenght:"+currentCell==null? null:currentCell.getStringCellValue().length());
						j++;
						break;
					case 20:
						stmt.setString(13, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 21:
						stmt2.setString(9, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 22:
						stmt2.setString(10, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 23:
						stmt2.setString(11, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 24:
						stmt4.setString(2, currentCell==null? null:currentCell.getStringCellValue());
						//System.out.println("Faq length:"+currentCell==null? null:currentCell.getStringCellValue().length());
						j++;
						break;
					case 25:
						stmt2.setString(12, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 26:
						stmt.setString(14, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 27:
						stmt2.setString(13, currentCell==null? null:currentCell.getStringCellValue());
						j++;
						break;
					case 28:
						cellpathanme=currentCell==null? null:currentCell.getStringCellValue();
						j++;
						break;
					default:
						System.out.println("default");
						j++;
						break;

					}
					
				}
				
				//System.out.println("Master");
				stmt2.addBatch();
				stmt4.addBatch();
				//System.out.println("sub master");
				File fileList[]=photoFolder.listFiles();
				String pathname=cellpathanme;
			
				String filename= pathname!=null? pathname.substring(pathname.lastIndexOf("\\")+1,pathname.length()):null;
				/*
				 * For B folder alone last Index would be \\, otherwise /
				 */
				System.out.println("filename"+filename);
				stmt.setString(15, filename);
				boolean imageAvailable=false;
				for(File f: fileList) {
					
					//System.out.println(filename);
					//System.out.println(f.getName());
					//System.out.println(filename.equalsIgnoreCase(f.getName()));
					
					if(f.isDirectory() && filename.equalsIgnoreCase(f.getName())) {
						for(File image:f.listFiles())
						{
							imageAvailable=true;
							FileInputStream fis=new FileInputStream(image);
							stmt3.setString(1, PadLeft(String.valueOf(imageRownum.getAndIncrement()), 10));
							stmt3.setString(2, primarykey);
							stmt3.setBinaryStream(3, (InputStream)fis,(int) image.length());
							stmt3.addBatch();
							//System.out.println("image");
						}
						
					}
				}
				stmt.setString(16, imageAvailable? "Y":"N");
				stmt.addBatch();
				
				System.out.println(Integer.parseInt(rownum.toString())-1 + "records added");
				if(Integer.parseInt(rownum.toString())%100==0) {
					System.out.println("Started.........................");
					stmt.executeLargeBatch();
					System.out.println("statement 1 executed");
					stmt2.executeLargeBatch();
					System.out.println("statement 2 executed");
					stmt3.executeLargeBatch();
					System.out.println("statement 3 executed");
					stmt4.executeLargeBatch();
					System.out.println("statement 4 executed");
					System.out.println("Finished..........................");
					stmt.close();
					stmt2.close();
					stmt3.close();
					stmt4.close();
					conn.commit();
					conn.close();
					
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					conn.setAutoCommit(false);
					stmt = conn.prepareStatement("insert into pharma_medi_mast(pmm_medi_id,"
							+ " pmm_drug_name,"
							+ " pmm_composition,"
							+ " pmm_manufact, "
							+ "pmm_mrp,"
							+ " pmm_price,"
							+ " pmm_package_vol, "
							+ "pmm_presc_type,"
							+ " pmm_medi_use, "
							+ "pmm_how_use, "
							+ "pmm_safety_advice,"
							+ " pmm_alter_brand,"
							+ " pmm_related_product,"
							+ " pmm_manufact_addr,pmm_image_path ,pmm_image_avail ) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					stmt2=conn.prepareStatement("insert into pharma_medi_info(pmi_med_id,"
							+ " pmi_into_desc, "
							+ "pmi_side_effects,"
							+ " pmi_how_cope, "
							+ "pmi_how_work,"
							+ " pmi_if_forgot,"
							+ " pmi_expert_advice,"
							+ " pmi_interaction_drug, "
							//+ "pmi_patient_concern,"
							+ " pmi_feedback,"
							+ " pmi_ayurvedic_ingreden, "
							+ "pmi_related_lab_test,"
							//+ " pmi_faq, "
							+ "pmi_reference,"
							+ " pmi_vendor_partner) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
					
					stmt3=conn.prepareStatement("insert into pharma_medi_images(pmi_image_id, pmi_medi_id, pmi_image) values(?,?,?)");
					stmt4=conn.prepareStatement("insert into pharma_medi_faq(pmf_medi_id,pmf_faq,pmf_patient_concern) values(?,?,?)");
					
				}

			}
			
			System.out.println("Started.........................");
			stmt.executeLargeBatch();
			System.out.println("statement2 1 executed");
			stmt2.executeLargeBatch();
			System.out.println("statement2 2 executed");
			stmt3.executeLargeBatch();
			System.out.println("statement2 3 executed");
			stmt4.executeLargeBatch();
			System.out.println("statement2 4 executed");
			System.out.println("Finished..........................");
			
			stmt.close();
			stmt2.close();
			stmt3.close();
			stmt4.close();
			conn.commit();
			
			 }
		} catch (FileNotFoundException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
			conn.rollback();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			conn.close();
			
		}
		finally {
			workbook.close();
		}

	}
	
	
	public static String  getFilesList(String key) {
		return folderMap.get(key);
		
	}
	
	public static String getPhotoFolder(String key) {
		return photoMap.get(key);
	}
	
	
	public static final Map<String,String> folderMap=new HashMap() {
		
		{
			//put("A","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_A.xlsx");
			
			put("B","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_B.xlsx");
			 // put("C","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_C.xlsx");
			 // put("D","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_D.xlsx");
			// put("E","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_E.xlsx");
			//  put("F","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_F.xlsx");
			 // put("G","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_G.xlsx");
			//  put("H","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_H.xlsx");
			//  put("I","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_I.xlsx");
			//  put("J","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_J.xlsx");
			//  put("K","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_K.xlsx");
			//  put("L","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_L.xlsx");
			// put("M","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_M.xlsx");
			//  put("N","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_N.xlsx");
			//  put("O","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_O.xlsx");
			//  put("P","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_P.xlsx");
			//  put("Q","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_Q.xlsx");
			//  put("R","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_R.xlsx");
			//  put("S","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_S.xlsx");
			//  put("T","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_T.xlsx");
			//  put("U","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_U.xlsx");
			//  put("V","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_V.xlsx");
			 // put("W","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_W.xlsx");
			 // put("X","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_X.xlsx");
			//  put("Y","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_Y.xlsx");
			// put("Z","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_Z.xlsx"); 
			// put("NoAlpha","/Users/suvins/MyPharma/Pharmacy databse/MedicineData_NoAlpha.xlsx");
			 
		}
		
	};
	
	public static final Map<String,String> photoMap=new HashMap() {
		{
			//put("A","/Users/suvins/MyPharma/Pharmacy Images/drugImage_A/drugs/");
			
			 put("B","/Users/suvins/MyPharma/Pharmacy Images/drugImage_B/drugs/");
			  //put("C","/Users/suvins/MyPharma/Pharmacy Images/drugImage_C/drugs/");
			  //put("D","/Users/suvins/MyPharma/Pharmacy Images/drugImage_D/drugs/");
			  //put("E","/Users/suvins/MyPharma/Pharmacy Images/drugImage_E/drugs/");
			  //put("F","/Users/suvins/MyPharma/Pharmacy Images/drugImage_F/drugs/");
			  //put("G","/Users/suvins/MyPharma/Pharmacy Images/drugImage_G/drugs/");
			 // put("H","/Users/suvins/MyPharma/Pharmacy Images/drugImage_H/drugs/");
			  //put("I","/Users/suvins/MyPharma/Pharmacy Images/drugImage_I/drugs/");
			  //put("J","/Users/suvins/MyPharma/Pharmacy Images/drugImage_J/drugs/");
			 // put("K","/Users/suvins/MyPharma/Pharmacy Images/drugImage_K/drugs/");
			 // put("L","/Users/suvins/MyPharma/Pharmacy Images/drugImage_L/drugs/");
			  //put("M","/Users/suvins/MyPharma/Pharmacy Images/drugImage_M/drugs/");
			 // put("N","/Users/suvins/MyPharma/Pharmacy Images/drugImage_N/drugs/");
			  //put("O","/Users/suvins/MyPharma/Pharmacy Images/drugImage_O/drugs/");
			// put("P","/Users/suvins/MyPharma/Pharmacy Images/drugImage_P/drugs/");
			 // put("Q","/Users/suvins/MyPharma/Pharmacy Images/drugImage_Q/drugs/");
			 // put("R","/Users/suvins/MyPharma/Pharmacy Images/drugImage_R/drugs/");
			 // put("S","/Users/suvins/MyPharma/Pharmacy Images/drugImage_S/drugs/");
			 //put("T","/Users/suvins/MyPharma/Pharmacy Images/drugImage_T/drugs/");
			 // put("U","/Users/suvins/MyPharma/Pharmacy Images/drugImage_U/drugs/");
			 //put("V","/Users/suvins/MyPharma/Pharmacy Images/drugImage_V/drugs/");
			//  put("W","/Users/suvins/MyPharma/Pharmacy Images/drugImage_W/drugs/");
			 // put("X","/Users/suvins/MyPharma/Pharmacy Images/drugImage_X/drugs/");
			// put("Y","/Users/suvins/MyPharma/Pharmacy Images/drugImage_Y/drugs/");
			 // put("Z","/Users/suvins/MyPharma/Pharmacy Images/drugImage_Z/drugs/"); 
			 // put("NoAlpha","/Users/suvins/MyPharma/Pharmacy Images/drugImage_NoAlpha/drugs/");
			 
			
		}
		
	};

}
