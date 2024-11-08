from flask import Flask,render_template,request
import subprocess

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('home.html')

@app.route('/math', methods = ['GET','POST'])
def prime():
    if request.method == 'GET':
        return render_template('home.html')
    elif request.method == 'POST':
        number = request.form.get('n')
        try:
            process =  subprocess.Popen(
                ['java','main'],
                stdin=subprocess.PIPE,
                stdout=subprocess.PIPE,
                stderr=subprocess.PIPE,
                text=True
            )
            result, error = process.communicate(input=number)

            if error:
                return render_template(template_name_or_list='home.html',error = "an error occured" + error)

            result = result.strip()
            return render_template(template_name_or_list='home.html',result=result)
        except Exception as e:
            return f"an error occured"

if __name__ == '__main__':
    app.run(debug=True)
