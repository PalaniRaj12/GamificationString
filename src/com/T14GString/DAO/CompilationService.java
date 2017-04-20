package com.T14GString.DAO;

public class CompilationService 
{

	public void verifyTestCase(CompilationForm compilationForm,AdminForm adminForm) 
	{
		String input[]={adminForm.getTc1input(),adminForm.getTc2input(),adminForm.getTc3input(),
				adminForm.getTc4input(),adminForm.getTc5input()};
		String output[]={adminForm.getTc1output(),adminForm.getTc2output(),adminForm.getTc3output(),
				adminForm.getTc4output(),adminForm.getTc5output()};
		String Routput[]=new String[5];
		String Rerr[]=new String[5];
		int passedCount=0;
		for(int i=0;i<5;i++)
		{
		    CompilationForm compilationform = new CompilationDAO().compileCode(compilationForm, input[i]);
		    Routput[i]=compilationform.getStdout();
		    Rerr[i]=compilationform.getStderr();
		    String[] resultString=compilationform.getStdout().split(System.getProperty("line.separator"));
		    if(resultString[resultString.length-1].trim().equals(output[i]))
		    	passedCount++;
		}
		compilationForm.setPercentage(passedCount*20);
		compilationForm.setTc1Routput(Routput[0]);
		compilationForm.setTc2Routput(Routput[1]);
		compilationForm.setTc3Routput(Routput[2]);
		compilationForm.setTc4Routput(Routput[3]);
		compilationForm.setTc5Routput(Routput[4]);
		compilationForm.setTc1Rerr(Rerr[0]);
		compilationForm.setTc2Rerr(Rerr[1]);
		compilationForm.setTc3Rerr(Rerr[2]);
		compilationForm.setTc4Rerr(Rerr[3]);
		compilationForm.setTc5Rerr(Rerr[4]);
		
	}
	
}
