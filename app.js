function gcd(a, b)
{
    if (b == 0)
        return a;
    return gcd(b, a % b);
}

function calcTriples(n1, n2)
{
	var output = "";
	if (n1 > n2)
		n1 = n1 + n2 - (n2 = n1);
	if (n1 < 3)
		n1 = 3;
	if (n1 != n2 && n2 > 4)
	{
		var b = 1, i = 0, f = 1;
		for (var a = 2;; a += 2)
		{
			if (gcd(a, b) != 1)
				continue;
			var p = 2 * a * b, q = a * a - b * b;
			if (p > q)
				p = p + q - (q = p);
			if (p < n1)
			{
				f = 1;
				continue;
			}
			var r = a * a + b * b;
			if (r <= n2 && p >= n1)
			{
				i++;
				f = 1;
				output += i + " (" + p + ", " + q + ", " + r + ")\n";
			}
			else if (f != 0)
			{
				a = b++;
				f = 0;
			}
			else
				break;
		}
	}
	return output;
}

function calculateTriples() {
    const n1 = parseInt(document.getElementById('n1').value);
    const n2 = parseInt(document.getElementById('n2').value);
    const output = calcTriples(n1, n2);
    document.getElementById('triples-output').textContent = output;
}

class acot
{
    constructor(x, n)
    {
        this.x = 10;
        this.n = n;
        var i = 1n;
        this.s = this.t = 10n ** BigInt(n + this.x) / BigInt(x);
        this.x2 = BigInt(x * x);
        while (this.t !== 0n)
        {
            i += 2n;
            this.t /= -this.x2;
            this.s += this.t / i;
        }
    }

    valueOf(x, n)
    {
        return new acot(x, n).toString();
    }

    toString()
    {
        var acotx = bigIntAbs(this.s / (10n ** BigInt(this.n + this.x))).toString() + "." + zfill((this.s / (10n ** BigInt(this.x))) % (10n ** BigInt(this.n)), this.n);
        if (this.s < 0n)
            acotx = "-" + acotx;
        return acotx;
    }
}

function bigIntAbs(value)
{
    return value < 0n ? -value : value;
}

function zfill(number, width)
{
    const numString = String(number);
    return numString.padStart(width, '0');
}

function machin(a, b, nterms, n, x)
{
    var PiBy4 = new Big(0);
    for (var i = 0; i < nterms; ++i)
        PiBy4 = PiBy4.plus(new Big(a[i]).times(Object.create(acot.prototype).valueOf(b[i], n + x)).toString());
    return PiBy4;
}

function pi(n)
{
    const a = [183, 32, -68, 12, -12, -100];
    const b = [239, 1023, 5832, 110443, 4841182, 6826318];
    const nterms = 6, x = 10;
    return new Big(4).times(machin(a, b, nterms, n, x));
}

function calcAcot(x, n)
{
	var output = "";
	if (n > 0)
	{
		Big.DP = n;
		Big.RM = 0;
		const Pi = pi(n);
		if (x == 0)
			var ntimes = 8;
		else
			var ntimes = parseInt(Math.log10(Math.abs(x))) + (x / Math.abs(x) === 1 ? 8 : 9);
		if (Math.abs(x) !== 1 && x !== 0)
		{
			const acotx = new acot(x, n);
			var acotx_str = acotx.toString();
			var Acotx = Big(acotx_str);
			output += "acot(" + x + ") = " + acotx_str + " rad\n";
			output += ' '.repeat(ntimes);
			var Acotx_deg = new Big(180).times(Acotx).div(Pi);
			const Acotx_deg_str = Acotx_deg.toString();
			output += "= " + Acotx_deg_str + "°\n";
		}
		else
		{
			var Acotx = new Big(x === 0 ? 1 : x).times(Pi).div(new Big(x === 0 ? 2 : 4));
			var acotx_str = Acotx.toString();
			output += "acot(" + x + ") = " + acotx_str + " rad\n";
			output += ' '.repeat(ntimes);
			var Acotx_deg = new Big(x === 0 ? 90 : 45 * x);
			const Acotx_deg_str = Acotx_deg.toString();
			output += "= " + Acotx_deg_str + "°\n";
		}
		const signum = acotx_str == '0' ? 0 : new Big(acotx_str[0] == '-' ? -1 : 1);
		const Atanx = signum.times(Pi.div(new Big(2)).minus(Acotx.abs()));
		const Atanx_str = Atanx.toString();
		output += "atan(" + x + ") = " + Atanx_str + " rad\n";
		output += ' '.repeat(ntimes);
		const Atanx_deg = signum.times(new Big(90).minus(Acotx_deg.abs()));
		const Atanx_deg_str = Atanx_deg.toString();
		output += "= " + Atanx_deg_str + "°\n";
	}
	return output;
}

function calculateAcot() {
    const x = parseInt(document.getElementById('x').value);
    const digits = parseInt(document.getElementById('digits').value);
    const output = calcAcot(x, digits);
    document.getElementById('acot-output').textContent = output;
}
