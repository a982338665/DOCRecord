package test.exceltest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import pers.lishbo.util.PoiUtil;

public class ExcelReadUtil {

	public static void main(String[] args) throws Exception {
		String url = "C:/Users/cjh/Desktop/allstudents.xlsx";
		Map<String, Object> map1 = null;
		InputStream is2 = new FileInputStream(url);
		String fileType = url.substring(url.lastIndexOf(".") + 1, url.length());
		boolean isXls = true;
		if (fileType.equals("xls")) {
			isXls = true;
		} else if (fileType.equals("xlsx")) {
			isXls = false;
		} else {
			is2.close();
//			return new ResultBean(0, 0, "", "格式不符合");
		}
		Map<Integer, String> excelContent = PoiUtil.getExcelContent(url);
		System.err.println(excelContent);
//		 List<List<String>> excelAll = PoiUtil.getExcelAll(url);
//		 for (List<String> list : excelAll) {
//			System.out.println(list.toString());
//		}
		readExcelContent(is2, isXls);
	}
	
	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 * @throws IOException
	 */
	public static List<String> readExcelContent(InputStream is,
			boolean isXls) throws IOException {
				return null;/*
		Workbook wb = null;
		Sheet sheet = null;
		Row row = null;
		if (isXls) {
			wb = new HSSFWorkbook(is);
		} else {
			wb = new XSSFWorkbook(is);
		}
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		List<String> bbtList = new ArrayList<String>();
		PoiUtil poiUtil = new PoiUtil();
		// 正文内容应该从第二行开始,第一行为表头的标题
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			C2SBbtImportSSTBean bbtBean = new C2SBbtImportSSTBean();
			C2SBbtImportSchoolBean schoolBean = new C2SBbtImportSchoolBean();
			C2SBbtImportTeacherBean teachBean = new C2SBbtImportTeacherBean();
			List<C2SBbtImportTeachInfoBean> teachInfoList = new ArrayList<C2SBbtImportTeachInfoBean>();
			C2SBbtImportTeachInfoBean teachInfoBean = new C2SBbtImportTeachInfoBean();
			while (j < colNum) {
				switch (j) {
				case 0: {
					// 地市id
					schoolBean.setDsId(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}
				case 1: {
					// 地市名称
					schoolBean.setDsName(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}
				case 2: {
					// 区县id
					schoolBean.setQxId(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}
				case 3: {
					// 区县
					schoolBean.setQxName(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}

				case 4: {
					// 学校id
					schoolBean.setSchoolId(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					teachBean.setSchoolId(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}
				case 5: {
					// 学校
					schoolBean.setSchoolName(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}

				case 6: {
					// 学校类型
					schoolBean.setSchoolType("28");
					break;
				}

				case 7: {
					// 教师id
					teachBean.setTeacherId(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}

				case 8: {
					// 教师姓名
					teachBean.setTeacherName(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}
				case 9: {
					// 教师电话
					teachBean.setTeacherPhone(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}

				case 10: {
					// 教师账号
					teachBean.setTeacherZh(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}

				case 11: {
					String pwd = poiUtil.getCellFormatValue(row.getCell(j))
							.trim();
					// 教师密码
					teachBean.setTeacherPwd(MD5Util.MD5(pwd));
					break;
				}

				case 12: {
					// 教师职务

					break;
				}

				case 13: {
					// 任职班级id
					teachInfoBean.setClassId(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}

				case 14: {
					// 任职班级
					teachInfoBean.setClassName(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}

				case 15: {
					// 任职年级
					teachInfoBean.setGradeNum(poiUtil.getCellFormatValue(
							row.getCell(j)).trim());
					break;
				}

				case 16: {
					// 任教科目名称
					*//**
					 * 生物 37 美术 32 历史 34 物理 35 语文 26 英语 28 化学 36 数学 27 地理 33 音乐
					 * 31 体育 30 自然 41 班主任 18 副班主任 19 政治 29 任课教师 40
					 *//*
					getCode(teachInfoBean,
							poiUtil.getCellFormatValue(row.getCell(j)).trim());
					break;
				}

				}
				j++;
			}
			teachInfoList.add(teachInfoBean);
			int k = i + 1;
			for (int m = k; m < k + 8; m++) {
				if (m > rowNum) {
					break;
				}
				row = sheet.getRow(m);
				String name = poiUtil.getStringCellValue(row.getCell(8)).trim();
				String phone = poiUtil.getStringCellValue(row.getCell(9))
						.trim();
				if (teachBean.getTeacherPhone().equals(phone)
						&& teachBean.getTeacherName().equals(name)) {
					C2SBbtImportTeachInfoBean teachInfoBean2 = new C2SBbtImportTeachInfoBean();
					teachInfoBean2.setClassId(poiUtil.getStringCellValue(
							row.getCell(13)).trim());
					teachInfoBean2.setClassName(poiUtil.getStringCellValue(
							row.getCell(14)).trim());
					teachInfoBean2.setGradeNum(poiUtil.getStringCellValue(
							row.getCell(15)).trim());
					getCode(teachInfoBean2,
							poiUtil.getStringCellValue(row.getCell(16)).trim());
					teachInfoList.add(teachInfoBean2);
					i = m;
				}
			}
			teachBean.setTeachInfoBean(teachInfoList);
			bbtBean.setSchoolBean(schoolBean);
			bbtBean.setTeacherBean(teachBean);
			bbtList.add(bbtBean);
		}
		return bbtList;
	*/}
}
