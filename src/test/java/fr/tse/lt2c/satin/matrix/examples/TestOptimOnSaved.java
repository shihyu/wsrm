package fr.tse.lt2c.satin.matrix.examples;

import java.io.File;

import fr.tse.lt2c.satin.matrix.beans.BinaryMatrix;
import fr.tse.lt2c.satin.matrix.beans.DecompositionResult;
import fr.tse.lt2c.satin.matrix.extraction.linkedmatrix.refactored.WSMRDecomposer;
import fr.tse.lt2c.satin.matrix.utils.MatrixParser;

public class TestOptimOnSaved {

	private static final int MINRECTANGLESIZE = 1;

	public static void main(String[] args) {
		BinaryMatrix matrix = MatrixParser.binaryMatrixFromFile(new File("matrix.txt"));
		System.out.println(matrix.getNumberOfOnes());

		WSMRDecomposer largestCompute = new WSMRDecomposer(matrix, false, false, false);
		System.out.println(matrix);
		DecompositionResult res = largestCompute.computeDecomposition(MINRECTANGLESIZE);
		System.out.println(res.totalArea());
		System.out.println(res.reconstructMatrix(matrix.getRow(), matrix.getCol()));
		System.out.println(matrix.difference(res.reconstructMatrix(matrix.getRow(), matrix.getCol())));
		// Collections.sort(res.getRectangle());
		System.out.println(res);
		System.out.println(res.overlappingRectangles());

	}

}
