# Automated-Data-Pipeline-Aithent
This project implements an end-to-end automated workflow for student data management. It streamlines database operations, data export to CSV, email notifications, and analytics chart generation using Oracle, Java, and Python. 

## Features 
- Automatic student ID generation using Oracle sequences and triggers
- PL/SQL procedure for exporting student data to CSV files with dynamic date-based filenames
- Modular Java programs for database connection, procedure execution, and email sending
- Python script for converting CSV files to Excel and generating pivot charts
- One-command execution for end-to-end data export, distribution, and visualization

## Technologies Used
- Oracle SQL Developer, PL/SQL
- Java (JDBC, JavaMail API)
- Python (pandas, openpyxl, matplotlib)

## Future Enhancements 
- Schedule exports and email via cron jobs
- Integrate a lightweight UI for end-users
- Support for cloud storage (Google Drive, Dropbox, etc.)

## References 
- https://docs.oracle.com/cd/E12151_01/index.htm
- https://www.geeksforgeeks.org/java/jdbc-tutorial/
- https://javaee.github.io/javamail/docs/api/
- https://pandas.pydata.org/docs/
- https://openpyxl.readthedocs.io/en/stable/
- https://matplotlib.org/stable/index.html
