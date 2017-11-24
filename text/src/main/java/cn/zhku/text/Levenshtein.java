package cn.zhku.text;


/**
 * Levenshtein Distance�㷨
 * @author wxshi
 *
 */
public class Levenshtein {

	/**
	 * @param s1
	 * @param s2
	 * @return Levenshtein Distance
	 */
	public double getStringDistance(String s1, String s2) {

		double distance[][];// ��������
		int s1_len = s1.length();
		int s2_len = s2.length();

		if (s1_len == 0) {
			return s2_len;
		}
		if (s2_len == 0) {
			return s1_len;
		}
		distance = new double[s1_len + 1][s2_len + 1];

		// ��ά�����һ�к͵�һ�з�����Ȼ��
		for (int i = 0; i <= s1_len; i++) {
			distance[i][0] = i;
		}
		for (int j = 0; j <= s2_len; j++) {
			distance[0][j] = j;
		}
		// �Ƚϣ���������ͬ������Ϊ0��������Ϊ1��
		for (int i = 1; i <= s1_len; i++) {
			char s1_i = s1.charAt(i - 1);
			// ��һ�Ƚ�
			for (int j = 1; j <= s2_len; j++) {
				char s2_j = s2.charAt(j - 1);
				// ����ȣ�����ȡ0��ֱ��ȡ���Ϸ�ֵ
				if (s1_i == s2_j) {
					distance[i][j] = distance[i - 1][j - 1];
				} else {
					// ������ȡ1��ȡ���Ͻǡ����� ��Сֵ + ��ۣ����֮�ͱ������վ��룩
					distance[i][j] = getMin(distance[i - 1][j], distance[i][j - 1], distance[i - 1][j - 1]) + 1;
				}
			}
		}
		// ȡ��λ�������һλ���������ַ�֮��ľ���
		return distance[s1_len][s2_len];
	}

	// ����Сֵ
	private double getMin(double a, double b, double c) {
		double min = a;
		if (b < min) {
			min = b;
		}
		if (c < min) {
			min = c;
		}
		return min;
	}
}