/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.solr.client.solrj.io;

import org.apache.solr.client.solrj.io.eval.*;
import org.apache.solr.client.solrj.io.graph.GatherNodesStream;
import org.apache.solr.client.solrj.io.graph.ShortestPathStream;
import org.apache.solr.client.solrj.io.ops.ConcatOperation;
import org.apache.solr.client.solrj.io.ops.DistinctOperation;
import org.apache.solr.client.solrj.io.ops.FieldValueMergeOperation;
import org.apache.solr.client.solrj.io.ops.GroupOperation;
import org.apache.solr.client.solrj.io.ops.ReplaceOperation;
import org.apache.solr.client.solrj.io.stream.*;
import org.apache.solr.client.solrj.io.stream.expr.StreamFactory;
import org.apache.solr.client.solrj.io.stream.metrics.CountMetric;
import org.apache.solr.client.solrj.io.stream.metrics.MaxMetric;
import org.apache.solr.client.solrj.io.stream.metrics.MeanMetric;
import org.apache.solr.client.solrj.io.stream.metrics.MinMetric;
import org.apache.solr.client.solrj.io.stream.metrics.SumMetric;

public class Lang {

  public static void register(StreamFactory streamFactory) {
    streamFactory
        // source streams
        .withFunctionName("search", CloudSolrStream.class)
        .withFunctionName("facet", FacetStream.class)
        .withFunctionName("update", UpdateStream.class)
        .withFunctionName("jdbc", JDBCStream.class)
        .withFunctionName("topic", TopicStream.class)
        .withFunctionName("commit", CommitStream.class)
        .withFunctionName("random", RandomStream.class)
        .withFunctionName("knnSearch", KnnStream.class)

            // decorator streams
        .withFunctionName("merge", MergeStream.class)
        .withFunctionName("unique", UniqueStream.class)
        .withFunctionName("top", RankStream.class)
        .withFunctionName("fieldValueMerge", FieldValueMergeOperation.class)
        .withFunctionName("group", GroupOperation.class)
        .withFunctionName("reduce", ReducerStream.class)
        .withFunctionName("parallel", ParallelStream.class)
        .withFunctionName("rollup", RollupStream.class)
        .withFunctionName("stats", StatsStream.class)
        .withFunctionName("innerJoin", InnerJoinStream.class)
        .withFunctionName("leftOuterJoin", LeftOuterJoinStream.class)
        .withFunctionName("hashJoin", HashJoinStream.class)
        .withFunctionName("outerHashJoin", OuterHashJoinStream.class)
        .withFunctionName("intersect", IntersectStream.class)
        .withFunctionName("complement", ComplementStream.class)
        .withFunctionName("sort", SortStream.class)
        .withFunctionName("train", TextLogitStream.class)
        .withFunctionName("features", FeaturesSelectionStream.class)
        .withFunctionName("daemon", DaemonStream.class)
        .withFunctionName("shortestPath", ShortestPathStream.class)
        .withFunctionName("gatherNodes", GatherNodesStream.class)
        .withFunctionName("nodes", GatherNodesStream.class)
        .withFunctionName("select", SelectStream.class)
        .withFunctionName("shortestPath", ShortestPathStream.class)
        .withFunctionName("gatherNodes", GatherNodesStream.class)
        .withFunctionName("nodes", GatherNodesStream.class)
        .withFunctionName("scoreNodes", ScoreNodesStream.class)
        .withFunctionName("model", ModelStream.class)
        .withFunctionName("fetch", FetchStream.class)
        .withFunctionName("executor", ExecutorStream.class)
        .withFunctionName("null", NullStream.class)
        .withFunctionName("priority", PriorityStream.class)
        .withFunctionName("significantTerms", SignificantTermsStream.class)
        .withFunctionName("cartesianProduct", CartesianProductStream.class)
        .withFunctionName("shuffle", ShuffleStream.class)
        .withFunctionName("calc", CalculatorStream.class)
        .withFunctionName("eval", EvalStream.class)
        .withFunctionName("echo", EchoStream.class)
        .withFunctionName("cell", CellStream.class)
        .withFunctionName("list", ListStream.class)
        .withFunctionName("let", LetStream.class)
        .withFunctionName("get", GetStream.class)
        .withFunctionName("timeseries", TimeSeriesStream.class)
        .withFunctionName("tuple", TupStream.class)
        .withFunctionName("sql", SqlStream.class)

            // metrics
        .withFunctionName("min", MinMetric.class)
        .withFunctionName("max", MaxMetric.class)
        .withFunctionName("avg", MeanMetric.class)
        .withFunctionName("sum", SumMetric.class)
        .withFunctionName("count", CountMetric.class)

            // tuple manipulation operations
        .withFunctionName("replace", ReplaceOperation.class)
        .withFunctionName("concat", ConcatOperation.class)

            // stream reduction operations
        .withFunctionName("group", GroupOperation.class)
        .withFunctionName("distinct", DistinctOperation.class)
        .withFunctionName("having", HavingStream.class)

            // Stream Evaluators
        .withFunctionName("val", RawValueEvaluator.class)

            // New Evaluators
        .withFunctionName("anova", AnovaEvaluator.class)
        .withFunctionName("array", ArrayEvaluator.class)
        .withFunctionName("col", ColumnEvaluator.class)
        .withFunctionName("conv", ConvolutionEvaluator.class)
        .withFunctionName("copyOfRange", CopyOfRangeEvaluator.class)
        .withFunctionName("copyOf", CopyOfEvaluator.class)
        .withFunctionName("cov", CovarianceEvaluator.class)
        .withFunctionName("corr", CorrelationEvaluator.class)
        .withFunctionName("describe", DescribeEvaluator.class)
        .withFunctionName("distance", DistanceEvaluator.class)
        .withFunctionName("empiricalDistribution", EmpiricalDistributionEvaluator.class)
        .withFunctionName("finddelay", FindDelayEvaluator.class)
        .withFunctionName("hist", HistogramEvaluator.class)
        .withFunctionName("length", LengthEvaluator.class)
        .withFunctionName("movingAvg", MovingAverageEvaluator.class)
        .withFunctionName("standardize", NormalizeEvaluator.class)
        .withFunctionName("percentile", PercentileEvaluator.class)
        .withFunctionName("predict", PredictEvaluator.class)
        .withFunctionName("rank", RankEvaluator.class)
        .withFunctionName("regress", RegressionEvaluator.class)
        .withFunctionName("rev", ReverseEvaluator.class)
        .withFunctionName("scale", ScaleEvaluator.class)
        .withFunctionName("sequence", SequenceEvaluator.class)
        .withFunctionName("addAll", AppendEvaluator.class)
        .withFunctionName("append", AppendEvaluator.class)
        .withFunctionName("plot", PlotStream.class)
        .withFunctionName("normalDistribution", NormalDistributionEvaluator.class)
        .withFunctionName("uniformDistribution", UniformDistributionEvaluator.class)
        .withFunctionName("sample", SampleEvaluator.class)
        .withFunctionName("kolmogorovSmirnov", KolmogorovSmirnovEvaluator.class)
        .withFunctionName("ks", KolmogorovSmirnovEvaluator.class)
        .withFunctionName("asc", AscEvaluator.class)
        .withFunctionName("cumulativeProbability", CumulativeProbabilityEvaluator.class)
        .withFunctionName("ebeAdd", EBEAddEvaluator.class)
        .withFunctionName("ebeSubtract", EBESubtractEvaluator.class)
        .withFunctionName("ebeMultiply", EBEMultiplyEvaluator.class)
        .withFunctionName("ebeDivide", EBEDivideEvaluator.class)
        .withFunctionName("dotProduct", DotProductEvaluator.class)
        .withFunctionName("cosineSimilarity", CosineSimilarityEvaluator.class)
        .withFunctionName("freqTable", FrequencyTableEvaluator.class)
        .withFunctionName("uniformIntegerDistribution", UniformIntegerDistributionEvaluator.class)
        .withFunctionName("binomialDistribution", BinomialDistributionEvaluator.class)
        .withFunctionName("poissonDistribution", PoissonDistributionEvaluator.class)
        .withFunctionName("enumeratedDistribution", EnumeratedDistributionEvaluator.class)
        .withFunctionName("probability", ProbabilityEvaluator.class)
        .withFunctionName("sumDifference", SumDifferenceEvaluator.class)
        .withFunctionName("meanDifference", MeanDifferenceEvaluator.class)
        .withFunctionName("primes", PrimesEvaluator.class)
        .withFunctionName("factorial", FactorialEvaluator.class)
        .withFunctionName("movingMedian", MovingMedianEvaluator.class)
        .withFunctionName("binomialCoefficient", BinomialCoefficientEvaluator.class)
        .withFunctionName("expMovingAvg", ExponentialMovingAverageEvaluator.class)
        .withFunctionName("monteCarlo", MonteCarloEvaluator.class)
        .withFunctionName("constantDistribution", ConstantDistributionEvaluator.class)
        .withFunctionName("weibullDistribution", WeibullDistributionEvaluator.class)
        .withFunctionName("mean", MeanEvaluator.class)
        .withFunctionName("mode", ModeEvaluator.class)
        .withFunctionName("logNormalDistribution", LogNormalDistributionEvaluator.class)
        .withFunctionName("zipFDistribution", ZipFDistributionEvaluator.class)
        .withFunctionName("gammaDistribution", GammaDistributionEvaluator.class)
        .withFunctionName("betaDistribution", BetaDistributionEvaluator.class)
        .withFunctionName("polyfit", PolyFitEvaluator.class)
        .withFunctionName("harmonicFit", HarmonicFitEvaluator.class)
        .withFunctionName("loess", LoessEvaluator.class)
        .withFunctionName("matrix", MatrixEvaluator.class)
        .withFunctionName("transpose", TransposeEvaluator.class)
        .withFunctionName("unitize", UnitEvaluator.class)
        .withFunctionName("triangularDistribution", TriangularDistributionEvaluator.class)
        .withFunctionName("precision", PrecisionEvaluator.class)
        .withFunctionName("minMaxScale", MinMaxScaleEvaluator.class)
        .withFunctionName("markovChain", MarkovChainEvaluator.class)
        .withFunctionName("grandSum", GrandSumEvaluator.class)
        .withFunctionName("scalarAdd", ScalarAddEvaluator.class)
        .withFunctionName("scalarSubtract", ScalarSubtractEvaluator.class)
        .withFunctionName("scalarMultiply", ScalarMultiplyEvaluator.class)
        .withFunctionName("scalarDivide", ScalarDivideEvaluator.class)
        .withFunctionName("sumRows", SumRowsEvaluator.class)
        .withFunctionName("sumColumns", SumColumnsEvaluator.class)
        .withFunctionName("diff", TimeDifferencingEvaluator.class)
        .withFunctionName("corrPValues", CorrelationSignificanceEvaluator.class)
        .withFunctionName("normalizeSum", NormalizeSumEvaluator.class)
        .withFunctionName("geometricDistribution", GeometricDistributionEvaluator.class)
        .withFunctionName("olsRegress", OLSRegressionEvaluator.class)
        .withFunctionName("derivative", DerivativeEvaluator.class)
        .withFunctionName("spline", SplineEvaluator.class)
        .withFunctionName("ttest", TTestEvaluator.class)
        .withFunctionName("pairedTtest", PairedTTestEvaluator.class)
        .withFunctionName("multiVariateNormalDistribution", MultiVariateNormalDistributionEvaluator.class)
        .withFunctionName("integrate", IntegrateEvaluator.class)
        .withFunctionName("density", DensityEvaluator.class)
        .withFunctionName("mannWhitney", MannWhitneyUEvaluator.class)
        .withFunctionName("sumSq", SumSqEvaluator.class)
        .withFunctionName("akima", AkimaEvaluator.class)
        .withFunctionName("lerp", LerpEvaluator.class)
        .withFunctionName("chiSquareDataSet", ChiSquareDataSetEvaluator.class)
        .withFunctionName("gtestDataSet", GTestDataSetEvaluator.class)
        .withFunctionName("termVectors", TermVectorsEvaluator.class)
        .withFunctionName("getColumnLabels", GetColumnLabelsEvaluator.class)
        .withFunctionName("getRowLabels", GetRowLabelsEvaluator.class)
        .withFunctionName("getAttribute", GetAttributeEvaluator.class)
        .withFunctionName("kmeans", KmeansEvaluator.class)
        .withFunctionName("getCentroids", GetCentroidsEvaluator.class)
        .withFunctionName("getCluster", GetClusterEvaluator.class)
        .withFunctionName("topFeatures", TopFeaturesEvaluator.class)
        .withFunctionName("featureSelect", FeatureSelectEvaluator.class)
        .withFunctionName("rowAt", RowAtEvaluator.class)
        .withFunctionName("colAt", ColumnAtEvaluator.class)
        .withFunctionName("setColumnLabels", SetColumnLabelsEvaluator.class)
        .withFunctionName("setRowLabels", SetRowLabelsEvaluator.class)
        .withFunctionName("knn", KnnEvaluator.class)
        .withFunctionName("getAttributes", GetAttributesEvaluator.class)
        .withFunctionName("indexOf", IndexOfEvaluator.class)
        .withFunctionName("columnCount", ColumnCountEvaluator.class)
        .withFunctionName("rowCount", RowCountEvaluator.class)
        .withFunctionName("fuzzyKmeans", FuzzyKmeansEvaluator.class)
        .withFunctionName("getMembershipMatrix", GetMembershipMatrixEvaluator.class)
        .withFunctionName("multiKmeans", MultiKmeansEvaluator.class)
        .withFunctionName("l2norm", NormEvaluator.class)
        .withFunctionName("l1norm", L1NormEvaluator.class)
        .withFunctionName("linfnorm", LInfNormEvaluator.class)
        .withFunctionName("matrixMult", MatrixMultiplyEvaluator.class)
        .withFunctionName("bicubicSpline", BicubicSplineEvaluator.class)
        .withFunctionName("valueAt", ValueAtEvaluator.class)
        .withFunctionName("memset", MemsetEvaluator.class)
        .withFunctionName("fft", FFTEvaluator.class)
        .withFunctionName("ifft", IFFTEvaluator.class)
        .withFunctionName("manhattan", ManhattanEvaluator.class)
        .withFunctionName("canberra", CanberraEvaluator.class)
        .withFunctionName("earthMovers", EarthMoversEvaluator.class)
        .withFunctionName("euclidean", EuclideanEvaluator.class)
        .withFunctionName("chebyshev", ChebyshevEvaluator.class)
        .withFunctionName("ones", OnesEvaluator.class)
        .withFunctionName("zeros", ZerosEvaluator.class)
        .withFunctionName("getValue", GetValueEvaluator.class)
        .withFunctionName("setValue", SetValueEvaluator.class)

        // Boolean Stream Evaluators

        .withFunctionName("and", AndEvaluator.class)
        .withFunctionName("eor", ExclusiveOrEvaluator.class)
        .withFunctionName("eq", EqualToEvaluator.class)
        .withFunctionName("gt", GreaterThanEvaluator.class)
        .withFunctionName("gteq", GreaterThanEqualToEvaluator.class)
        .withFunctionName("lt", LessThanEvaluator.class)
        .withFunctionName("lteq", LessThanEqualToEvaluator.class)
        .withFunctionName("not", NotEvaluator.class)
        .withFunctionName("or", OrEvaluator.class)

            // Date Time Evaluators
        .withFunctionName(TemporalEvaluatorYear.FUNCTION_NAME, TemporalEvaluatorYear.class)
        .withFunctionName(TemporalEvaluatorMonth.FUNCTION_NAME, TemporalEvaluatorMonth.class)
        .withFunctionName(TemporalEvaluatorDay.FUNCTION_NAME, TemporalEvaluatorDay.class)
        .withFunctionName(TemporalEvaluatorDayOfYear.FUNCTION_NAME, TemporalEvaluatorDayOfYear.class)
        .withFunctionName(TemporalEvaluatorHour.FUNCTION_NAME, TemporalEvaluatorHour.class)
        .withFunctionName(TemporalEvaluatorMinute.FUNCTION_NAME, TemporalEvaluatorMinute.class)
        .withFunctionName(TemporalEvaluatorSecond.FUNCTION_NAME, TemporalEvaluatorSecond.class)
        .withFunctionName(TemporalEvaluatorEpoch.FUNCTION_NAME, TemporalEvaluatorEpoch.class)
        .withFunctionName(TemporalEvaluatorWeek.FUNCTION_NAME, TemporalEvaluatorWeek.class)
        .withFunctionName(TemporalEvaluatorQuarter.FUNCTION_NAME, TemporalEvaluatorQuarter.class)
        .withFunctionName(TemporalEvaluatorDayOfQuarter.FUNCTION_NAME, TemporalEvaluatorDayOfQuarter.class)

            // Number Stream Evaluators
        .withFunctionName("abs", AbsoluteValueEvaluator.class)
        .withFunctionName("add", AddEvaluator.class)
        .withFunctionName("div", DivideEvaluator.class)
        .withFunctionName("mult", MultiplyEvaluator.class)
        .withFunctionName("sub", SubtractEvaluator.class)
        .withFunctionName("log", NaturalLogEvaluator.class)
        .withFunctionName("pow", PowerEvaluator.class)
        .withFunctionName("mod", ModuloEvaluator.class)
        .withFunctionName("ceil", CeilingEvaluator.class)
        .withFunctionName("floor", FloorEvaluator.class)
        .withFunctionName("sin", SineEvaluator.class)
        .withFunctionName("asin", ArcSineEvaluator.class)
        .withFunctionName("sinh", HyperbolicSineEvaluator.class)
        .withFunctionName("cos", CosineEvaluator.class)
        .withFunctionName("acos", ArcCosineEvaluator.class)
        .withFunctionName("cosh", HyperbolicCosineEvaluator.class)
        .withFunctionName("tan", TangentEvaluator.class)
        .withFunctionName("atan", ArcTangentEvaluator.class)
        .withFunctionName("tanh", HyperbolicTangentEvaluator.class)
        .withFunctionName("round", RoundEvaluator.class)
        .withFunctionName("sqrt", SquareRootEvaluator.class)
        .withFunctionName("cbrt", CubedRootEvaluator.class)
        .withFunctionName("coalesce", CoalesceEvaluator.class)
        .withFunctionName("uuid", UuidEvaluator.class)

            // Conditional Stream Evaluators
        .withFunctionName("if", IfThenElseEvaluator.class)
        .withFunctionName("convert", ConversionEvaluator.class);
  }
}