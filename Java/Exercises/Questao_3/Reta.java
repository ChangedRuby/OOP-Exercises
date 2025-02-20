package Questao_3;

public class Reta {
	double angular = 0;
	double linear = 0;
	
	Reta(double angular, double linear){
		this.angular = angular;
		this.linear = linear;
	}
	
	Reta(double x, double y, double x2, double y2){
		angular = (y2 - y) / (x2 - x);
		linear = y - angular * x;
	}
	
	public boolean check(double x, double y) {
		if(angular * x + linear == y) {
			return true;
		} else {
			return false;
		}
	}
	
	public double[] intersection(Reta reta) {
		double[] point = new double[2];
		point[0] = (reta.getLinear() - linear) / (angular - reta.getAngular());
		point[1] = angular * (reta.getLinear() - linear) / (angular - reta.getAngular()) + linear;
		return point;
	}
	
	public double getAngular() {
		return angular;
	}
	
	public double getLinear() {
		return linear;
	}
}
