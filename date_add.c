#include<stdio.h>
#include<stdlib.h>
int print_next_day(int, int, int);
int main(int argc, char * argv[])
{
    int year;
    int month;
    int day;
    printf("please input year: ");
    scanf("%d", &year);
    printf("please input month: ");
    scanf("%d", &month);
    printf("please input day: ");
    scanf("%d", &day);
    
    if(!print_next_day(year, month, day))
    {
        printf("ilegal input!\n");
    }
    return 0;
}

int print_next_day(int year, int month, int day)
{
    int year_to_print = year;
    int month_to_print = month;
    int day_to_print = day;
    if(month <= 0 || month > 12 || day <= 0 || day >31)
    {
        return 0;
    }
    if(day == 31)
    {
        if(month==2||month==4||month==6||month==9||month==11)
        {
            return 0;
        }
        else
        {
            day_to_print = 1;
            month_to_print++;
            if(month_to_print == 13)
            {
                month_to_print = 1;
                year_to_print++;
            }
        }
    }
    else if(day == 30)
    {
        if(month==2)
        {
            return 0;
        }
        else if(month==4||month==6||month==9||month==11)
        {
            day_to_print = 1;
            month_to_print++;
        }
        else
        {
            day_to_print++;
        }
    }
    else if(day == 29 && month == 2)
    {
        if((year % 400 == 0)||(year % 100 != 0 && year % 4 == 0))
        {
            month_to_print = 3;
            day_to_print = 1;
        }
        else
        {
            return 0;
        }
    }
    else if(day == 28 && month ==2)
    {
        if((year % 400 == 0)||(year % 100 != 0 && year % 4 == 0))
        {
            day_to_print++;
        }
        else
        {
            month_to_print = 3;
            day_to_print = 1;
        }
    }
    else
    {
        day_to_print++;
    }
    printf("%d %d %d", year_to_print, month_to_print, day_to_print);
    printf("\n");
    return 1;
}

