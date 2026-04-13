// Databricks Notebook — Apache Spark RDD Data Pipeline
// Course: MEM6287 Advanced Data Analytics | University of Ottawa | Fall 2024
// Author: Nabeegh Khan

// ─────────────────────────────────────────────────────────────────────────────
// OVERVIEW
// Demonstrates low-level Spark RDD API for distributed text corpus processing.
// Dataset: Multi-file text corpus (~22 files) loaded from Databricks FileStore.
// ─────────────────────────────────────────────────────────────────────────────

// COMMAND ----------

// Verify SparkContext is active
spark.sparkContext

// COMMAND ----------

// List uploaded files in DBFS table space
// dbutils.fs.ls = Databricks Utilities → FileSystem → List
display(dbutils.fs.ls("/FileStore/tables/Text_Corpus/txt"))

// COMMAND ----------

// Load entire text corpus into a low-level RDD using SparkContext.textFile
// textFile reads all files in the directory, returning one RDD element per line
val textFile = spark.sparkContext.textFile("/FileStore/tables/Text_Corpus/txt")

// Count total number of lines across all files
textFile.count()

// COMMAND ----------

// Preview first 5 lines
textFile.take(5)

// COMMAND ----------

// Filter lines containing the word "antibiotics" and count occurrences
// Demonstrates RDD transformation (filter) + action (count)
val linesWithAntibiotics = textFile.filter(line => line.contains("antibiotics"))
linesWithAntibiotics.count()
