FROM python:3.12-slim

WORKDIR /app

COPY requirements.txt requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

# Install netcat-openbsd
RUN apt-get update && apt-get install -y netcat-openbsd

COPY wait-for-services.sh wait-for-services.sh
RUN chmod +x wait-for-services.sh

COPY sync.py sync.py

CMD ["./wait-for-services.sh", "34.142.186.206", "5432", "elasticsearch", "9200", "python", "sync.py"]