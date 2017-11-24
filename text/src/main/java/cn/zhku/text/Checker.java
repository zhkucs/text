package cn.zhku.text;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Checker {
	private final List<PaperInfo> paperInfos;
	

	public Checker(String file) {
		this.paperInfos = read(file);
	}

	private List<PaperInfo> read(String file) {
		List<PaperInfo> ps = new ArrayList<PaperInfo>();
		try (InputStream is2 = new FileInputStream(file)) {
			ExcelReader excelReader = new ExcelReader();
			Map<Integer, String> map = excelReader.readExcelContent(is2);
			Set<Teacher> ts = new HashSet();
			for(Integer row : map.keySet()){
				String rowContent = map.get(row);
				//1.0$信息与计算科学$2013$201321314430$曾灿生$基于Java的废品环保分类回收信息系统的设计与实现$吴东庆$副教授$生产实践$$
				String[] cols = rowContent.split("\\$");
				
				try {
					int no = 1;
					String spec = cols[no++].trim();
					int grade = (int)Double.parseDouble(cols[no++]);
					String clzNo = cols[no++].trim();
					String name = cols[no++].trim();
					String title = cols[no++].trim();
					Author author = new Author(spec, cols[2].trim(), name, "");
					Teacher teacher = new Teacher(cols[5]);
					PaperInfo pi = new PaperInfo(author, title, grade, teacher);
					ps.add(pi);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}								
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps;
	}

	

	public void dump(int grade, String outputFile) throws Exception {
		Map<Author, List<CompareResult>> result = compare(grade);
		
		List<CompareResult> cc = new ArrayList();
		for(Author a : result.keySet()){
			cc.addAll(result.get(a));
		}
		Collections.sort(cc);
		String[] rowName = {"序号","学号","作者","论文名称","作者2","论文名称2","距离"};
		List<Object[]> ccc = new ArrayList();
		for(CompareResult c : cc){
			ccc.add(c.toArray());
		}
		ExcelExporter ee = new ExcelExporter("查重结果", rowName , ccc);
		ee.export(outputFile);
	}

	public Map<Author, List<CompareResult>> compare(int grade) {
		Levenshtein ls = new Levenshtein();
		Map<Author, List<CompareResult>> crs = new HashMap();
		for (int i = 0; i < paperInfos.size(); i++) {
			PaperInfo p1 = paperInfos.get(i);
			if (grade != p1.getGrade()) {
				continue;
			}

			if (!crs.containsKey(p1.getAuthor())) {
				crs.put(p1.getAuthor(), new ArrayList<CompareResult>());
			}
			for (int j = i + 1; j < paperInfos.size(); j++) {
				PaperInfo p2 = paperInfos.get(j);
				double s = ls.getStringDistance(p1.getTitle2(), p2.getTitle2());
				
				CompareResult cr = new CompareResult(p1, p2, s);
				//cr.display();
				crs.get(p1.getAuthor()).add(cr);
			}
		}
		return crs;
	}
}
