# Big data analytics: Apache Spark and Azure Synapse

Coursework in distributed data processing, done for MEM6287 Advanced Data Analytics at the University of Ottawa (Fall 2024). Three assignments covering Spark (RDD and DataFrame APIs), Spark SQL, and cloud SQL analytics on Azure Synapse.

This is introductory big-data coursework, not a research project. It's here to show hands-on familiarity with the Spark/Scala/Databricks/Synapse stack.

## What's in it

**1. Spark RDD pipeline** — `notebooks/assignment-2-spark/data_pipeline_rdd.scala`
Low-level RDD API on Databricks: load a ~22-file text corpus with `SparkContext.textFile`, count lines across files, and filter for keyword occurrences across partitions. The point was to work directly with the transformation/action model and lazy evaluation.

**2. Spark DataFrame + SQL retail analysis** — `notebooks/assignment-2-spark/retail_analysis_dataframe_sql.scala`
Higher-level DataFrame API and Spark SQL on the UK Online Retail dataset (~25 daily CSVs, Dec 2010 – Dec 2011): ingest partitioned CSVs with schema inference, register a SQL view, compute total transaction value, and find the top products by quantity and revenue and the top countries by revenue.

**3. Azure Synapse bike-rental analysis** — `notebooks/assignment-3-azure-synapse/bike_rental_synapse_analysis.sql`
T-SQL on Azure Synapse over Bay Area Bike Share data (August 2015, ~24 MB, trip + station tables): load into the Synapse workspace, rank top pickup zip codes, break down rental duration by subscriber type, and resolve station names by joining the trip and station tables.

## Data

- UK Online Retail dataset (UCI Machine Learning Repository)
- Bay Area Bike Share, August 2015 (`201508_trip_data.csv`, `201508_station_data.csv`)

## Running these

These aren't local scripts. The Spark files are Scala notebooks written for Databricks (data staged on DBFS); the SQL file runs in an Azure Synapse workspace against data in Azure Data Lake. To reproduce, load the datasets into the respective environment and run each file there.

## Contributors

Group coursework for MEM6287 (University of Ottawa, Fall 2024), completed with Maurice Williams and Scott Bailey.
