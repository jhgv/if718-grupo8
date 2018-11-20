package com.ufpe.Escola.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ufpe.Escola.domain.model.Aluno;


@Controller(value="matriculaEnsinoFundamentalControlador")
@Scope("view")
public class MatriculaEnsinoFundamentalController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String teste;
	
	private Aluno alunoAserMatriculado;

	// TESTE
	private BubbleChartModel bubbleModel1;

	@PostConstruct
	public void init() {
		createBubbleModels();
	}

	private void createBubbleModels() {
		bubbleModel1 = initBubbleModel();
//		bubbleModel1.setTitle("Bubble Chart");
//		bubbleModel1.getAxis(AxisType.X).setLabel("Price");
//		Axis yAxis = bubbleModel1.getAxis(AxisType.Y);
//		yAxis.setMin(0);
//		yAxis.setMax(250);
//		yAxis.setLabel("Labels");
	}

	private BubbleChartModel initBubbleModel() {
		BubbleChartModel model = new BubbleChartModel();
		BubbleChartSeries acura = new BubbleChartSeries("Acura", 70, 183, 55);
		
		
		BubbleChartSeries alfa = new BubbleChartSeries("Alfa Romeo", 45, 92, 36);
		BubbleChartSeries gm = new BubbleChartSeries("AM General", 24, 104, 40);
		BubbleChartSeries bugatti = new BubbleChartSeries("Bugatti", 50, 123, 60);
		BubbleChartSeries bmw = new BubbleChartSeries("BMW", 15, 89, 25);
		BubbleChartSeries audi = new BubbleChartSeries("Audi", 40, 180, 80);
		BubbleChartSeries aston = new BubbleChartSeries("Aston Martin", 70, 70, 48);
		
		model.add(acura);
		model.add(alfa);
		model.add(gm);
		model.add(bugatti);
		model.add(bmw);
		model.add(audi);
		model.add(aston);
		return model;
	}


	public BubbleChartModel getBubbleModel1() {
		return bubbleModel1;
	}


	public void setBubbleModel1(BubbleChartModel bubbleModel1) {
		this.bubbleModel1 = bubbleModel1;
	}


	public String getTeste() {
		return "olha eu ai!!!!!!!!!!!!!!!!";
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}
	
}