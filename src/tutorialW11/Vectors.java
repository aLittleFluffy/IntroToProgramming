package tutorialW11;

public class Vectors{

    private static double getVectorMagnitude(double[] inputVector){
        double insideSqrt = 0;
        for (double vector : inputVector) {
            insideSqrt = insideSqrt + Math.pow(vector, 2);
        }
        return Math.sqrt(insideSqrt);
    }

    private static double[] normalizeVector(double[] vector){
        double[] responseVector = new double[vector.length];
        for(int count=0; count<vector.length; count++){
            responseVector[count] = vector[count]/getVectorMagnitude(vector);
        }
        return responseVector;
    }

    private static double dotProduct(double[] vector1, double[] vector2){
        double responseNum = 0;
        if(vector1.length==vector2.length){
            for(int count=0; count<vector1.length; count++){
                responseNum = responseNum + (vector1[count]*vector2[count]);
            }
            return responseNum;
        } else{
            throw new IllegalArgumentException("Vectors must have same number of dimensions");
        }
    }

    private static double[] addVectors(double[] vector1, double[] vector2){
        if(vector1.length==vector2.length){
            double[] responseVector = new double[vector1.length];
            for(int count=0; count<vector1.length; count++){
                responseVector[count] = (vector1[count]+vector2[count]);
            }
            return responseVector;
        } else{
            throw new IllegalArgumentException("Vectors must have same number of dimensions");
        }
    }
}
