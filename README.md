# Big Data Analytics: Apache Spark & Azure Cloud Platforms

Graduate-level big data engineering projects completed as part of **MEM6287 Advanced Data Analytics** at the **University of Ottawa** (Fall 2024). Covers distributed data processing with Apache Spark (RDD and DataFrame APIs), Spark SQL, and cloud-based analytics using Microsoft Azure Synapse Analytics.

---

## Projects

### 1. Apache Spark — RDD Data Pipeline (`notebooks/assignment-2-spark/data_pipeline_rdd.scala`)

Distributed text corpus processing using the low-level **Spark RDD API** on Databricks.

**Tech:** Apache Spark, Scala, Databricks, DBFS  
**Key operations:**
- Loaded a multi-file text corpus (~22 files) into a distributed RDD using `SparkContext.textFile`
- Counted total lines across all files using RDD actions
- Applied RDD `filter` transformation to search for keyword occurrences across distributed partitions
- Demonstrated lazy evaluation and the transformation → action execution model

---

### 2. Apache Spark — Retail Data Analysis (`notebooks/assignment-2-spark/retail_analysis_dataframe_sql.scala`)

Multi-file retail transaction analysis using the high-level **Spark DataFrame API** and **Spark SQL** on Databricks.

**Tech:** Apache Spark, Scala, Spark SQL, Databricks, DBFS  
**Dataset:** UK Online Retail dataset (Dec 2010 – Dec 2011), ~25 daily CSV files  
**Key operations:**
- Ingested partitioned daily CSV files with schema inference into a unified Spark DataFrame
- Registered DataFrame as a Spark SQL temporary view for declarative querying
- Computed total aggregate transaction value across the full dataset
- Identified top 5 products by quantity sold and by total revenue
- Aggregated total purchase value by country to identify highest-revenue markets

---

### 3. Microsoft Azure Synapse Analytics — Bike Rental Analysis (`notebooks/assignment-3-azure-synapse/bike_rental_synapse_analysis.sql`)

Cloud-scale SQL analytics on Bay Area Bike Share data using **Azure Synapse Analytics**.

**Tech:** Microsoft Azure Synapse Analytics, T-SQL, Azure Data Lake  
**Dataset:** Bay Area Bike Share — August 2015 (201508_trip_data.csv + 201508_station_data.csv, ~24MB)  
**Key operations:**
- Loaded multi-table CSV data into Azure Synapse workspace via data ingestion pipeline
- Identified top 20 pickup zip codes using aggregation and ranking
- Analyzed monthly rental duration by subscriber type using date formatting and grouping
- Identified top 5 pickup and least-used drop-off terminals with station name resolution via **JOIN**
- Generated monthly rental summary with count and total duration metrics

---

## Technical Skills Demonstrated

| Skill | Tool/Technology |
|-------|----------------|
| Distributed data processing | Apache Spark (RDD + DataFrame APIs) |
| Big data querying | Spark SQL, T-SQL |
| Cloud-based analytics | Microsoft Azure Synapse Analytics |
| Notebook-based development | Databricks (Scala) |
| Data ingestion | DBFS, Azure Data Lake, CSV schema inference |
| Multi-file data pipelines | Spark partitioned reads |
| Data aggregation & ranking | GROUP BY, ORDER BY, TOP/LIMIT |
| Multi-table joins | JOIN across trip and station datasets |

---

## Context

These projects were completed as part of **MEM6287 Advanced Data Analytics** at the University of Ottawa, covering:
- Big Data fundamentals (Hadoop ecosystem, MapReduce, Spark architecture)
- NoSQL databases (MongoDB, Cassandra, CAP theorem)
- Cloud infrastructure for big data (Azure Synapse, Azure Data Lake, HDInsight)
- Real-time and batch processing frameworks

The technical content of this course is equivalent to UofT's **MIE1628H Cloud-Based Data Analytics**, covering the same core stack: Spark, Databricks, Hadoop, and Azure cloud services.

---

## Related Projects

- [Ontario Electricity Demand Forecasting](https://github.com/nabeegh-khan/ontario-electricity-forecasting) — ML pipeline, XGBoost, Neural Networks
- [6G Massive MIMO Resource Allocation: DQN vs Supervised Learning](https://github.com/nabeegh-khan/6g-massive-mimo-dqn) — Reinforcement learning, wireless communications
- [DeepSense 6G Beam Prediction](https://github.com/nabeegh-khan) — mmWave beam tracking, CNN/LSTM/RNN/DQN

---

*Graduate research portfolio — Nabeegh Khan | MEng ECE, University of Toronto (Expected Dec 2026)*
