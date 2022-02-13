base<-read.csv2("C:/Users/Navid/Documents/Etudes/M2 Info/Projet/comment-sont-vos-preferences-par-rapport-a-celles-de-vos-amis/ResultsExp.csv",
                header=TRUE, sep=";", dec=".")

baseLabelWiseKFirstsBW1 = base[base$method == "LabelWise" & base$subMethod == "kFirsts" & base$beamWidth == 1,]
baseLabelWiseKRandomsBW1 = base[base$method == "LabelWise" & base$subMethod == "kRandoms" & base$beamWidth == 1,]
baseLabelWiseKBestsBW1 = base[base$method == "LabelWise" & base$subMethod == "kBests" & base$beamWidth == 1,]

basePairWiseKFirstsBW1 = base[base$method == "PairWise" & base$subMethod == "kFirsts" & base$beamWidth == 1,]
basePairWiseKRandomsBW1 = base[base$method == "PairWise" & base$subMethod == "kRandoms" & base$beamWidth == 1,]
basePairWiseKBestsBW1 = base[base$method == "PairWise" & base$subMethod == "kBests" & base$beamWidth == 1,]

baseRankingWiseKFirstsBW1 = base[base$method == "RankingWise" & base$subMethod == "kFirsts" & base$beamWidth == 1,]
baseRankingWiseKRandomsBW1 = base[base$method == "RankingWise" & base$subMethod == "kRandoms" & base$beamWidth == 1,]
baseRankingWiseKBestsBW1 = base[base$method == "RankingWise" & base$subMethod == "kBests" & base$beamWidth == 1,]


baseLabelWiseKFirstsBW5 = base[base$method == "LabelWise" & base$subMethod == "kFirsts" & base$beamWidth == 5,]
baseLabelWiseKRandomsBW5 = base[base$method == "LabelWise" & base$subMethod == "kRandoms" & base$beamWidth == 5,]
baseLabelWiseKBestsBW5 = base[base$method == "LabelWise" & base$subMethod == "kBests" & base$beamWidth == 5,]

basePairWiseKFirstsBW5 = base[base$method == "PairWise" & base$subMethod == "kFirsts" & base$beamWidth == 5,]
basePairWiseKRandomsBW5 = base[base$method == "PairWise" & base$subMethod == "kRandoms" & base$beamWidth == 5,]
basePairWiseKBestsBW5 = base[base$method == "PairWise" & base$subMethod == "kBests" & base$beamWidth == 5,]

baseRankingWiseKFirstsBW5 = base[base$method == "RankingWise" & base$subMethod == "kFirsts" & base$beamWidth == 5,]
baseRankingWiseKRandomsBW5 = base[base$method == "RankingWise" & base$subMethod == "kRandoms" & base$beamWidth == 5,]
baseRankingWiseKBestsBW5 = base[base$method == "RankingWise" & base$subMethod == "kBests" & base$beamWidth == 5,]

par(mfrow = c(1,2))

plot(baseLabelWiseKFirstsBW1$beamDepth, baseLabelWiseKFirstsBW1$qualityScore, xlim = c(1,5), ylim = c(0,0.3),
    type="o", pch=16, col=1, main = "Bests 10 groups scores with LabelWise measure and beamWidth = 1", xlab="beamDepth", ylab="qualityScore")
lines(baseLabelWiseKRandomsBW1$beamDepth, baseLabelWiseKRandomsBW1$qualityScore, type="o", pch=16, col=2)
lines(baseLabelWiseKBestsBW1$beamDepth, baseLabelWiseKBestsBW1$qualityScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)

plot(baseLabelWiseKFirstsBW5$beamDepth, baseLabelWiseKFirstsBW5$qualityScore, xlim = c(1,5), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "Bests 10 groups scores with LabelWise measure and beamWidth = 5", xlab="beamDepth", ylab="qualityScore")
lines(baseLabelWiseKRandomsBW5$beamDepth, baseLabelWiseKRandomsBW5$qualityScore, type="o", pch=16, col=2)
lines(baseLabelWiseKBestsBW5$beamDepth, baseLabelWiseKBestsBW5$qualityScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)


plot(basePairWiseKFirstsBW1$beamDepth, basePairWiseKFirstsBW1$qualityScore, xlim = c(1,5), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "Bests 10 groups scores with PairWise measure and beamWidth = 1", xlab="beamDepth", ylab="qualityScore")
lines(basePairWiseKRandomsBW1$beamDepth, basePairWiseKRandomsBW1$qualityScore, type="o", pch=16, col=2)
lines(basePairWiseKBestsBW1$beamDepth, basePairWiseKBestsBW1$qualityScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)

plot(basePairWiseKFirstsBW5$beamDepth, basePairWiseKFirstsBW5$qualityScore, xlim = c(1,5), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "Bests 10 groups scores with PairWise measure and beamWidth = 5", xlab="beamDepth", ylab="qualityScore")
lines(basePairWiseKRandomsBW5$beamDepth, basePairWiseKRandomsBW5$qualityScore, type="o", pch=16, col=2)
lines(basePairWiseKBestsBW5$beamDepth, basePairWiseKBestsBW5$qualityScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)


plot(baseRankingWiseKFirstsBW1$beamDepth, baseRankingWiseKFirstsBW1$qualityScore, xlim = c(1,5), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "Bests 10 groups scores with RankingWise measure and beamWidth = 1", xlab="beamDepth", ylab="qualityScore")
lines(baseRankingWiseKRandomsBW1$beamDepth, baseRankingWiseKRandomsBW1$qualityScore, type="o", pch=16, col=2)
lines(baseRankingWiseKBestsBW1$beamDepth, baseRankingWiseKBestsBW1$qualityScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)

plot(baseRankingWiseKFirstsBW5$beamDepth, baseRankingWiseKFirstsBW5$qualityScore, xlim = c(1,5), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "Bests 10 groups scores with RankingWise measure and beamWidth = 5", xlab="beamDepth", ylab="qualityScore")
lines(baseRankingWiseKRandomsBW5$beamDepth, baseRankingWiseKRandomsBW5$qualityScore, type="o", pch=16, col=2)
lines(baseRankingWiseKBestsBW5$beamDepth, baseRankingWiseKBestsBW5$qualityScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)


plot(baseLabelWiseKFirstsBW1$beamDepth, baseLabelWiseKFirstsBW1$firstGroupScore, xlim = c(1,5), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "First group scores with LabelWise measure and beamWidth = 1", xlab="beamDepth", ylab="firstGroupScore")
lines(baseLabelWiseKRandomsBW1$beamDepth, baseLabelWiseKRandomsBW1$firstGroupScore, type="o", pch=16, col=2)
lines(baseLabelWiseKBestsBW1$beamDepth, baseLabelWiseKBestsBW1$firstGroupScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)

plot(baseLabelWiseKFirstsBW5$beamDepth, baseLabelWiseKFirstsBW5$firstGroupScore, xlim = c(1,5), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "First group scores with LabelWise measure and beamWidth = 5", xlab="beamDepth", ylab="firstGroupScore")
lines(baseLabelWiseKRandomsBW5$beamDepth, baseLabelWiseKRandomsBW5$firstGroupScore, type="o", pch=16, col=2)
lines(baseLabelWiseKBestsBW5$beamDepth, baseLabelWiseKBestsBW5$firstGroupScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)


plot(basePairWiseKFirstsBW1$beamDepth, basePairWiseKFirstsBW1$firstGroupScore, xlim = c(1,5), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "First group scores with PairWise measure and beamWidth = 1", xlab="beamDepth", ylab="firstGroupScore")
lines(basePairWiseKRandomsBW1$beamDepth, basePairWiseKRandomsBW1$firstGroupScore, type="o", pch=16, col=2)
lines(basePairWiseKBestsBW1$beamDepth, basePairWiseKBestsBW1$firstGroupScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)

plot(basePairWiseKFirstsBW5$beamDepth, basePairWiseKFirstsBW5$firstGroupScore, xlim = c(1,5), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "First group scores with PairWise measure and beamWidth = 5", xlab="beamDepth", ylab="firstGroupScore")
lines(basePairWiseKRandomsBW5$beamDepth, basePairWiseKRandomsBW5$firstGroupScore, type="o", pch=16, col=2)
lines(basePairWiseKBestsBW5$beamDepth, basePairWiseKBestsBW5$firstGroupScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)


plot(baseRankingWiseKFirstsBW1$beamDepth, baseRankingWiseKFirstsBW1$firstGroupScore, xlim = c(1,5), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "First group scores with RankingWise measure and beamWidth = 1", xlab="beamDepth", ylab="firstGroupScore")
lines(baseRankingWiseKRandomsBW1$beamDepth, baseRankingWiseKRandomsBW1$firstGroupScore, type="o", pch=16, col=2)
lines(baseRankingWiseKBestsBW1$beamDepth, baseRankingWiseKBestsBW1$firstGroupScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)

plot(baseRankingWiseKFirstsBW5$beamDepth, baseRankingWiseKFirstsBW5$firstGroupScore, xlim = c(1,5), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "First group scores with RankingWise measure and beamWidth = 5", xlab="beamDepth", ylab="firstGroupScore")
lines(baseRankingWiseKRandomsBW5$beamDepth, baseRankingWiseKRandomsBW5$firstGroupScore, type="o", pch=16, col=2)
lines(baseRankingWiseKBestsBW5$beamDepth, baseRankingWiseKBestsBW5$firstGroupScore, type="o", pch=16, col=3)
legend("topleft", legend = c("kFirsts", "kRandoms", "kBests"), col = c(1, 2, 3), pch = 16)


baseLabelWise = base[base$method == "LabelWise" & base$subMethod == "timer stop at x time",]
basePairWise = base[base$method == "PairWise" & base$subMethod == "timer stop at x time",]
baseRankingWise = base[base$method == "RankingWise" & base$subMethod == "timer stop at x time",]

par(mfrow = c(1,1))

plot(baseLabelWise$executionTime, baseLabelWise$qualityScore, xlim = c(1,900), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "Bests 10 groups scores with Timer", xlab="executionTime", ylab="qualityScore")
lines(basePairWise$executionTime, basePairWise$qualityScore, type="o", pch=16, col=2)
lines(baseRankingWise$executionTime, baseRankingWise$qualityScore, type="o", pch=16, col=3)
legend("topleft", legend = c("LabelWise", "PairWise", "RankingWise"), col = c(1, 2, 3), pch = 16)


plot(baseLabelWise$executionTime, baseLabelWise$firstGroupScore, xlim = c(1,900), ylim = c(0,0.3),
     type="o", pch=16, col=1, main = "First group scores with Timer", xlab="executionTime", ylab="firstGroupScore")
lines(basePairWise$executionTime, basePairWise$firstGroupScore, type="o", pch=16, col=2)
lines(baseRankingWise$executionTime, baseRankingWise$firstGroupScore, type="o", pch=16, col=3)
legend("topleft", legend = c("LabelWise", "PairWise", "RankingWise"), col = c(1, 2, 3), pch = 16)
